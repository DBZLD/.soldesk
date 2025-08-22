import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import { Box, TextField, IconButton, InputAdornment, Autocomplete, Typography, Button, Skeleton } from '@mui/material';
import SearchIcon from "@mui/icons-material/Search";
import axios from 'axios';
import TFTMatchAccordion from './TFTMatchAccordion';
import RiotAppBar from '../RiotAppBar';
import '../reset.css';
import './TFTcommon.css';

function TFTRecord() {
  const navigate = useNavigate();
  const location = useLocation();
  const searchParams = new URLSearchParams(location.search);
  const [options, setOptions] = useState([]);

  const pId = searchParams.get('id');
  const pTag = searchParams.get('tag');
  const [data, setData] = useState(null);
  const [isInvalid, setIsInvalid] = useState(false);
  const [id, setId] = useState(pId);
  const [tag, setTag] = useState(pTag);
  const [autocompleteValue, setAutocompleteValue] = useState(`${pId}${pTag ? `#${pTag}` : ''}`);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8080/riot/getTFTRecord', {
          params: { playerID: pId.replace(/\s/g, ""), playerTag: pTag.replace(/\s/g, "") }
        });
        setData(response.data);
        if (response.data?.bSuccess) {
          setIsInvalid(false);
          await axios.post('http://localhost:8080/db/addSearchDB', {
            id: response.data.playerProfileInfo.name,
            tag: response.data.playerProfileInfo.tag,
            icon: response.data.playerProfileInfo.iconURL,
            regalia: response.data.playerRankInfo.rank.tier + response.data.playerRankInfo.rank.rank,
          });
        } else {
          setIsInvalid(true);
        }
      } catch (error) {
        console.error('Error:', error);
        setIsInvalid(true);
        setData(null);
      }
    };
    fetchData();
  }, [pId, pTag]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    navigate(`/TFTRecord?id=${id}&tag=${tag}`);
  }

  const handleInputChange = async (e, newValue) => {
    let idValue = "";
    let tagValue = "";
    if (typeof newValue === "string") {
      if (newValue.includes('#')) [idValue, tagValue = ""] = newValue.split('#');
      else idValue = newValue;
      setId(idValue);
      setTag(tagValue);
      try {
        const response = await axios.get('http://localhost:8080/db/getSearchDB', {
          params: { id: idValue, tag: tagValue }
        });
        setOptions(response.data);
      } catch (error) {
        console.error("DB 검색 실패:", error);
      }
    }
  };

  function RegaliaBox({ title, data, isTurbo = false, sx = {} }) {
    return (
      <Box
        sx={{
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center',
          backgroundColor: "rgba(59, 59, 78, 0.6)",
          p: 2,
          borderRadius: 2,
          ...sx,
        }}
      >
        <Typography variant="h4" sx={{ mb: 1 }}>{title}</Typography>

        <Box sx={{ display: 'flex', alignItems: 'center', mb: 1, gap: 2 }}>
          <Box
            component="img"
            src={data.imgURL}
            alt="playerRegaliaImg"
            sx={{ width: 160, height: 160 }}
          />

          <Box sx={{ display: 'flex', flexDirection: 'column', justifyContent: 'center' }}>
            <Typography variant="h5" sx={{ fontWeight: 'bold' }}>
              {(isTurbo || isNoPointTier(data.tier)) ? `${data.tier}` : `${data.tier} ${data.rank}`}
            </Typography>

            {data.tier !== "랭크 없음" && (
              <Typography variant="h5">
                {isTurbo ? `${data.rank}점` : `${data.point}LP`}
              </Typography>
            )}
          </Box>
        </Box>

        {data.tier !== "랭크 없음" && (
          <Typography variant="h5" sx={{ mt: 1, textAlign: 'center' }}>
            {data.win}승 {data.lose}패
          </Typography>
        )}
      </Box>
    );
  }

  function isNoPointTier(tier) {
    return ["마스터", "그랜드마스터", "챌린저", "랭크 없음"].includes(tier);
  }

  return (
    <Box className='body'>
      {isInvalid ? (
        <>
          <RiotAppBar />
          <Box className="main" sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', mt: 5 }}>
            <Typography variant="h4" sx={{ mb: 3 }}>잘못된 아이디 또는 태그입니다</Typography>
            <Box component="form" onSubmit={handleSubmit} sx={{ width: 700 }}>
              <Autocomplete
                freeSolo
                options={options}
                disableClearable
                value={autocompleteValue}
                onChange={(event, newValue) => {
                  if (!newValue) return;
                  let idValue = "";
                  let tagValue = "";
                  if (typeof newValue === "string") {
                    if (newValue.includes("#")) [idValue, tagValue = ""] = newValue.split("#");
                    else idValue = newValue;
                  } else if (newValue.id && newValue.tag) {
                    idValue = newValue.id; tagValue = newValue.tag;
                  }
                  navigate(`/TFTRecord?id=${idValue}&tag=${tagValue}`);
                }}
                onInputChange={(event, newInputValue) => {
                  setAutocompleteValue(newInputValue);
                  handleInputChange(event, newInputValue);
                }}
                getOptionLabel={(option) => {
                  if (typeof option === "string") return option;
                  if (option.id && option.tag) return `${option.id}#${option.tag}`;
                  return option.id || "";
                }}
                renderOption={(props, option) => (
                  <Box component="li" {...props} sx={{ display: 'flex', alignItems: 'center', gap: 1 }}>
                    {option.icon && <Box component="img" src={option.icon} alt="icon" sx={{ width: 32, height: 32, borderRadius: '50%' }} />}
                    <Box>
                      <Typography sx={{ fontWeight: 'bold', color:'rgb(70, 70, 70)'}}>{option.id}#{option.tag}</Typography>
                      {option.regalia && <Typography variant="caption" color="gray">{option.regalia}</Typography>}
                    </Box>
                  </Box>
                )}
                PaperComponent={(props) => (
                  <Box {...props} sx={{ backgroundColor: 'rgba(126, 126, 182, 0.8)' }} />
                )}
                renderInput={(params) => (
                  <TextField
                    {...params}
                    label="아이디#태그"
                    variant="outlined"
                    fullWidth
                    InputLabelProps={{
                      sx: {
                        color: "rgba(170,170,170,0.7)",
                        "&.Mui-focused": { color: "rgba(200,200,200,1)" },
                        "&.MuiInputLabel-shrink": { color: "rgba(200,200,200,1)" },
                      },
                    }}
                    sx={{
                      "& .MuiOutlinedInput-root": {
                        "& fieldset": { borderColor: "rgba(54, 45, 104, 1)", borderWidth: 3 },
                        "&:hover fieldset": { borderColor: "rgba(54, 45, 104, 1)" },
                        "&.Mui-focused fieldset": { borderColor: "rgba(24, 14, 78, 1)" },
                        height: 70,
                      },
                    }}
                    InputProps={{
                      ...params.InputProps,
                      endAdornment: (
                        <InputAdornment position="end">
                          <IconButton type="submit">
                            <SearchIcon sx={{ color: "rgba(54, 45, 104, 1)" }} />
                          </IconButton>
                        </InputAdornment>
                      ),
                    }}
                  />
                )}
              />
            </Box>
          </Box>
        </>
      ) : data ? (
        <>
          <RiotAppBar />
          <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', mt: 5 }}>
            <Box sx={{ display: 'flex', alignItems: 'center', gap: 2, mb: 3, alignSelf: 'flex-start', ml: 25 }}>
              <Box sx={{ position: 'relative', display: 'inline-block' }}>
                <Box
                  component="img"
                  src={data.playerProfileInfo.iconURL}
                  alt="playerProfileIcon"
                  sx={{ width: 100, height: 100, borderRadius: '50%', border:'2px solid rgba(24, 14, 78, 1)' }}
                />
                <Box
                  sx={{
                    position: 'absolute',
                    bottom: 5,
                    left: '50%',
                    transform: 'translate(-50%, 50%)',
                    backgroundColor: 'rgba(87,78,126,0.9)',
                    color: '#fff',
                    borderRadius: '20%',
                    border:'1px solid rgba(24, 14, 78, 1)',
                    width: 24,
                    height: 20,
                    display: 'flex',
                    alignItems: 'center',
                    justifyContent: 'center',
                    fontWeight: 'bold',
                    fontSize: '0.75rem',
                    boxShadow: '0 0 4px rgba(0,0,0,0.5)'
                  }}
                >
                  {data.playerProfileInfo.level}
                </Box>
              </Box>

              <Box sx={{ display: 'flex', flexDirection: 'column', justifyContent: 'center', ml:2 }}>
                <Typography variant="h4">
                  {data.playerProfileInfo.name}#{data.playerProfileInfo.tag}
                </Typography>
                <Button
                  variant="outlined"
                  sx={{ mt: 2, width: 90, height:40, color: 'rgb(200, 200, 200)', backgroundColor:'rgba(24, 14, 78, 1)' }}
                  onClick={() => window.location.reload()}
                >
                  갱신
                </Button>
              </Box>
            </Box>

            <Box
              sx={{
                display: 'flex',
                justifyContent: 'center',
                mb: 6,
                mt: 2,
                gap: 6,
                width: '80%',
              }}
            >
              <RegaliaBox
                title="랭크"
                data={data.playerRankInfo.rank}
                sx={{ width: '30%', height: 300 }}
              />
              <RegaliaBox
                title="더블 업"
                data={data.playerRankInfo.doubleUp}
                sx={{ width: '30%', height: 300 }}
              />
              <RegaliaBox
                title="초고속 모드"
                data={data.playerRankInfo.turbo}
                isTurbo
                sx={{ width: '30%', height: 300 }}
              />
            </Box>
            <Box sx={{ width: '80%' }}>
              {data.matchInfo.map((match, idx) => (
                <TFTMatchAccordion key={idx} data={match} />
              ))}
            </Box>
          </Box>
        </>
      ) : (
        <>
        <Typography variant='h4' sx={{pt:2, pl:2}}>불러오는 중...</Typography>
          <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', }}>
        {/* 상단: 아이콘 + 레벨 + 아이디/갱신 */}
        <Box sx={{ display: 'flex', alignItems: 'center', gap: 2, mb: 3, alignSelf: 'flex-start', ml: 25 }}>
          {/* 프로필 아이콘 */}
          <Skeleton variant="circular" width={100} height={100} />
          
          {/* 아이디 + 갱신 버튼 */}
          <Box sx={{ display: 'flex', flexDirection: 'column', justifyContent: 'center' }}>
            <Skeleton variant="text" width={200} height={40} />
            <Skeleton variant="rectangular" width={100} height={36} sx={{ mt: 1 }} />
          </Box>
        </Box>

        {/* 하단: 랭크 박스 3개 */}
        <Box sx={{ display: 'flex', justifyContent: 'center', gap: 6, mb: 6, width: '80%' }}>
          {[1, 2, 3].map((i) => (
            <Box
              key={i}
              sx={{
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
                p: 2,
                backgroundColor: "rgba(59, 59, 78, 0.6)",
                borderRadius: 2,
                width: '30%',
              }}
            >
              {/* 제목 */}
              <Skeleton variant="text" width={80} height={30} sx={{ mb: 1 }} />
              
              {/* 랭크 이미지 + 티어/LP */}
              <Box sx={{ display: 'flex', alignItems: 'center', gap: 2, mb: 1 }}>
                <Skeleton variant="rectangular" width={100} height={100} />
                <Box sx={{ display: 'flex', flexDirection: 'column', justifyContent: 'center' }}>
                  <Skeleton variant="text" width={80} height={24} />
                  <Skeleton variant="text" width={60} height={24} sx={{ mt: 0.5 }} />
                </Box>
              </Box>

              {/* 승패 */}
              <Skeleton variant="text" width={60} height={24} />
            </Box>
          ))}
        </Box>

        {/* 매치 리스트 */}
        <Box sx={{ width: '80%' }}>
          {[1, 2, 3, 4, 5].map((i) => (
            <Box key={i} sx={{ display: 'flex', flexDirection: 'column', mb: 2 }}>
              <Skeleton variant="rectangular" width="100%" height={80} />
            </Box>
          ))}
        </Box>
      </Box>
      </>
      )}
    </Box>
  );
}

export default TFTRecord;
