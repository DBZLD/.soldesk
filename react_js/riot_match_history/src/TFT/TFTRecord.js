import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import { Box, TextField, IconButton, InputAdornment } from '@mui/material';
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

  const pId = searchParams.get('id');
  const pTag = searchParams.get('tag');

  const [data, setData] = useState(null);
  const [isInvalid, setIsInvalid] = useState(false);
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
        if (response.data?.bSuccess) {
          setIsInvalid(false);
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
  const [id, setId] = useState(pId);
  const [tag, setTag] = useState(pTag);
  const handleSubmit = async (e) => {
    e.preventDefault();
    navigate(`/TFTRecord?id=${id}&tag=${tag}`);
  }
  const handleInputChange = (e) => {
    const inputString = e.target.value;
    if (inputString.includes('#')) {
      const [idValue, tagValue] = inputString.split('#');
      setId(idValue);
      setTag(tagValue || '');
    } else {
      setId(inputString);
      setTag('');
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
function isNoPointTier(tier){
  if(tier === "마스터" || tier === "그랜드마스터" || tier === "챌린저" || tier === "랭크 없음"){
    return true;
  }
  return false;
}
  //~isInvalid가 true일때
  return (
    <div className='body'>
      {isInvalid ? (
        <>
        <RiotAppBar/>
        <div className='center'>
          <div className='errorTitle'>잘못된 아이디 또는 태그입니다</div>
          <Box
            component="form"
            onSubmit={handleSubmit}
            sx={{ display: "flex", alignItems: "center", mb: 3 }}
          >
          <TextField
            label="아이디#태그"
            variant="outlined"
            onChange={handleInputChange}
            defaultValue={`${pId}${pTag ? `#${pTag}` : ''}`}
            InputLabelProps={{
              sx: {
                color: "rgba(170, 170, 170, 0.4)",
                "&.MuiInputLabel-root:not(.Mui-focused):not(.MuiInputLabel-shrink)": {
                  top: "50%",
                  transform: "translateY(-50%)",
                  marginLeft:"15px",
                },
              },
            }}
            sx={{
              width: 700,
              "& .MuiOutlinedInput-root": {
                display: "flex",
                alignItems: "center",
                color: "white",
                "& fieldset": {
                  borderColor: "rgba(54, 45, 104, 1)",
                  borderWidth: 3,
                },
                "&:hover fieldset": {
                  borderColor: "rgba(54, 45, 104, 1)",
                },
                "&.Mui-focused fieldset": {
                  borderColor: "rgba(24, 14, 78, 1)",
                },
              },
            }}
            inputProps={{
              sx: {
                height: 40,
                color: "rgb(170, 170, 170)",
              },
            }}
            InputProps={{
              endAdornment: (
                <InputAdornment position="end">
                  <IconButton type="submit">
                    <SearchIcon sx={{ color: "rgba(54, 45, 104, 1)" }} />
                  </IconButton>
                </InputAdornment>
              ),
            }}
          />
          </Box>
        </div>
        </>
      ) : data ? (
        <>
          <RiotAppBar/>
        <div className='center'>
          <div className='profileArea'>
            <div className='profileBox'>
          <img id='icon' src={data.playerProfileInfo.iconURL} alt='playerProfileIcon'></img>
          <h4 id='level'>{data.playerProfileInfo.level}</h4>
            </div>
          <h1 id='name'>{data.playerProfileInfo.name}#{data.playerProfileInfo.tag}</h1>
          <button id='refresh'>전적 갱신</button>
          </div>
          <div className='rankArea'>
            <RegaliaBox title="랭크" data={data.playerRankInfo.rank}/>
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
