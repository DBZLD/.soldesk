import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import { Box, TextField, IconButton, InputAdornment, Autocomplete } from '@mui/material';
import SearchIcon from "@mui/icons-material/Search";
import axios from 'axios';
import TFTMatchAccordion from './TFTMatchAccordion';
import '../reset.css';
import './TFTcommon.css';
import RiotAppBar from '../RiotAppBar';

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
  const [autocompleteValue, setAutocompleteValue] = useState(`${pId}${pTag ? `#${pTag}` : ''}`);

  const [tag, setTag] = useState(pTag);
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8080/riot/getTFTRecord', {
          params: {
            playerID: pId.replace(/\s/g, ""),
            playerTag: pTag.replace(/\s/g, ""),
          },
        });
        console.log(response.data);
        setData(response.data);
        console.log(response.data.playerRankInfo.rank);
        if (response.data?.bSuccess) {
          setIsInvalid(false);
          await axios.post('http://localhost:8080/db/addAccount', {
            id: response.data.playerProfileInfo.name,
            tag: response.data.playerProfileInfo.tag,
            icon: response.data.playerProfileInfo.iconURL,
            regalia: response.data.playerRankInfo.rank.tier + response.data.playerRankInfo.rank.rank,
          });
          console.log("계정 저장 완료");
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

  // isInvalid가 true일때~
  const handleSubmit = async (e) => {
    e.preventDefault();
    navigate(`/TFTRecord?id=${id}&tag=${tag}`);
  }
  const handleInputChange = async (e, newValue) => {
    let idValue = "";
    let tagValue = "";

    if (typeof newValue === "string") {
      if (newValue.includes('#')) {
        [idValue, tagValue = ""] = newValue.split('#');
      } else {
        idValue = newValue;
        tagValue = '';
      }
      setId(idValue);
      setTag(tagValue);

      try {
        console.log(idValue);
        console.log(tagValue);
        const response = await axios.get('http://localhost:8080/db/getAccount', {
          params: {
            id: idValue,
            tag: tagValue,
          }
        });
        console.log("DB 저장 성공:", response.data);
        setOptions(response.data);
      } catch (error) {
        console.error("DB 저장 실패:", error);
      }
    }
  };

  function RegaliaBox({ title, data, isTurbo = false }) {
    return (
      <div className="rankBox">
        <h1 className="regaliaType">{title}</h1>
        <img className={isTurbo ? "turboRegaliaImg" : "regaliaImg"} src={data.imgURL} alt="playerRegaliaImg" />
        <h2 className="regaliaTier">{(isTurbo || isNoPointTier(data.tier)) ? `${data.tier}` : `${data.tier} ${data.rank}`}</h2>
        {data.tier !== "랭크 없음" && (
          <>
            <h2 className="regaliaPoint">{isTurbo ? `${data.rank}점` : `${data.point}LP`}</h2>
            <h2 className="regaliaWL">{data.win}승 {data.lose}패</h2>
          </>
        )}
      </div>
    );
  }
  function isNoPointTier(tier) {
    if (tier === "마스터" || tier === "그랜드마스터" || tier === "챌린저" || tier === "랭크 없음") {
      return true;
    }
    return false;
  }
  //~isInvalid가 true일때
  return (
    <div className='body'>
      {isInvalid ? (
        <>
          <RiotAppBar />
          <div className='center'>
            <div className='errorTitle'>잘못된 아이디 또는 태그입니다</div>
            <Box
              component="form"
              onSubmit={handleSubmit}
              sx={{ display: "flex", alignItems: "center", mb: 3 }}
            >
              <Autocomplete
                freeSolo
                options={options}
                disableClearable
                value={autocompleteValue} // controlled로 변경
                onChange={(event, newValue) => {
                  if (!newValue) return;

                  let idValue = "";
                  let tagValue = "";

                  if (typeof newValue === "string") {
                    if (newValue.includes("#")) {
                      [idValue, tagValue = ""] = newValue.split("#");
                    } else {
                      idValue = newValue;
                      tagValue = "";
                    }
                  } else if (newValue.id && newValue.tag) {
                    idValue = newValue.id;
                    tagValue = newValue.tag;
                  }

                  // 페이지 이동
                  navigate(`/TFTRecord?id=${idValue}&tag=${tagValue}`);
                }}
                onInputChange={(event, newInputValue) => {
                  setAutocompleteValue(newInputValue); // 입력값도 상태로 관리
                  handleInputChange(event, newInputValue); // 기존 DB 검색 호출
                }}
                getOptionLabel={(option) => {
                  if (typeof option === "string") return option;
                  if (option.id && option.tag) return `${option.id}#${option.tag}`;
                  if (option.id) return option.id;
                  return "";
                }}
                renderOption={(props, option) => (
                  <Box
                    component="li"
                    {...props}
                    sx={{ display: "flex", alignItems: "center", gap: 1 }}
                  >
                    {option.icon && (
                      <img src={option.icon} alt="icon" style={{ width: 32, height: 32, borderRadius: "50%" }} />
                    )}
                    <Box>
                      <div style={{ fontWeight: "bold" }}>{option.id}#{option.tag}</div>
                      {option.regalia && (
                        <div style={{ fontSize: "0.8rem", color: "gray" }}>{option.regalia}</div>
                      )}
                    </Box>
                  </Box>
                )}
                renderInput={(params) => (
                  <TextField
                    {...params}
                    label="아이디#태그"
                    variant="outlined"
                    InputLabelProps={{
                      sx: {
                        color: "rgba(170, 170, 170, 0.4)",
                        "&.MuiInputLabel-root:not(.Mui-focused):not(.MuiInputLabel-shrink)": {
                          top: "50%",
                          transform: "translateY(-50%)",
                          marginLeft: "15px",
                        },
                      },
                    }}
                    sx={{
                      width: 700,
                      "& .MuiOutlinedInput-root": {
                        display: "flex",
                        alignItems: "center",
                        color: "white",
                        "& fieldset": { borderColor: "rgba(54, 45, 104, 1)", borderWidth: 3 },
                        "&:hover fieldset": { borderColor: "rgba(54, 45, 104, 1)" },
                        "&.Mui-focused fieldset": { borderColor: "rgba(24, 14, 78, 1)" },
                      },
                    }}
                    inputProps={{ ...params.inputProps, sx: { height: 40, color: "rgb(170, 170, 170)" } }}
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
          </div>
        </>
      ) : data ? (
        <>
          <RiotAppBar />
          <div className='center'>
            <div className='profileArea'>
              <div className='profileBox'>
                <img id='icon' src={data.playerProfileInfo.iconURL} alt='playerProfileIcon'></img>
                <h4 id='level'>{data.playerProfileInfo.level}</h4>
              </div>
              <h1 id='name'>{data.playerProfileInfo.name}#{data.playerProfileInfo.tag}</h1>
              <button id='refresh' onClick={() => window.location.reload()}>전적 갱신</button>
            </div>
            <div className='rankArea'>
              <RegaliaBox title="랭크" data={data.playerRankInfo.rank} />
              <RegaliaBox title="더블 업" data={data.playerRankInfo.doubleUp} />
              <RegaliaBox title="초고속 모드" data={data.playerRankInfo.turbo} isTurbo />
            </div>
            <div className='recordArea'>
              {data.matchInfo.slice(0, data.matchInfo.length).map((match, index) => (
                <TFTMatchAccordion key={index} data={match} />
              ))}
            </div>
            <div className='seeMoreArea'>
              <button className='seeMoreButton'>더보기</button>
            </div>
          </div>
        </>
      ) : (
        <h2>데이터 불러오는 중...</h2>
      )}
    </div>
  );
}

export default TFTRecord;
