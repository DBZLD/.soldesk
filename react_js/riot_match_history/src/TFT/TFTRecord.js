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
  const searchParams = new URLSearchParams(location.search); // TFTMain에서 받아온 param
  const [options, setOptions] = useState([]); // 검색 결과가 올바르지 않을 때 나올 검색창에서 받아올 SearchDB

  const pId = searchParams.get('id');
  const pTag = searchParams.get('tag');
  console.log(pId);
  console.log(pTag);

  const [data, setData] = useState(null);
  const [isInvalid, setIsInvalid] = useState(false);
  const [id, setId] = useState(pId);
  const [tag, setTag] = useState(pTag);
  const [autocompleteValue, setAutocompleteValue] = useState(`${pId}${pTag ? `#${pTag}` : ''}`); // 검색창 초기 값 설정

  //받아온 id, tag로 spring에 API를 요청하고 API가 올바른지 확인하는 함수
  useEffect(() => {
    const fetchData = async () => {
      setData(null);
      try {
        const response = await axios.get('http://localhost:8080/riot/getTFTRecord', {
          params: { playerID: pId.replace(/\s/g, ""), playerTag: pTag.replace(/\s/g, "") } // id, tag로 라이엇 API 요청
        });
        setData(response.data);
        console.log(response.data);
        if (response.data?.bSuccess) { // 요청에 문제가 없을 때
          setIsInvalid(false);
          await axios.post('http://localhost:8080/db/addSearchDB', { //SearchDB에 계정 정보 저장(중복은 spring에서 걸러냄)
            id: response.data.playerProfileInfo.name,
            tag: response.data.playerProfileInfo.tag,
            icon: response.data.playerProfileInfo.iconURL,
            regalia: setRegalia(response.data),
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

  // SearchDB에 보낼 Regalia 설정
  function setRegalia(data) {
    const { tier, rank, point } = data.playerRankInfo.rank;
    const fallbackTier = data.playerRankInfo.rank.tier;

    return tier === '랭크 없음' //tier가 랭크 없음인지 확인
      ? fallbackTier //랭크 없음이면 fallbackTier 반환
      : ["마스터", "그랜드마스터", "챌린저"].includes(tier) // 아니면 includes확인
        ? `${tier} ${point}LP`  //true면 tier, point 반환
        : `${tier}${rank} ${point}LP`; // false면 tier, rank, point 반환
  }

  //결과가 올바르지 않은 화면에서 검색 시 실행되는 함수
  const handleSubmit = async (e) => {
    e.preventDefault();
    navigate(`/TFTRecord?id=${id}&tag=${tag}`); //TFTRecord에 매개변수를 가지고 이동
  }

  //결과가 올바르지 않은 화면에서 검색어 변경 시 실행되는 함수
  const handleInputChange = async (e, newValue) => {
    let idValue = "";
    let tagValue = "";
    if (typeof newValue === "string") { // newValue의 타입이 string일때만 실행
      if (newValue.includes('#')) [idValue, tagValue = ""] = newValue.split('#'); // 검색어가 #을 포함한다면 #을 기준으로 앞은 idValue로 뒤는 tagValue로 설정
      else idValue = newValue; //포함하지 않는다면 검색어 전체를 idValue로 설정
      setId(idValue);
      setTag(tagValue);
      //SearchDB에 param 전달하고 자동완성 정보 요청
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

  //랭크 박스 디자인
  function RegaliaBox({ title, data, isTurbo = false, sx = {} }) {
    return (
      // 메인 랭크 박스
      <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', backgroundColor: "rgba(59, 59, 78, 0.6)", p: 2, borderRadius: 2, ...sx, }}>
        <Typography variant="h4" sx={{ mb: 1 }}>{title}</Typography> {/* 랭크 종류 제목 */}
        {/* 랭크 이미지, 랭크, 티어 */}
        <Box sx={{ display: 'flex', alignItems: 'center', mb: 1, gap: 2 }}>
          <Box component="img" src={data.imgURL} alt="playerRegaliaImg" sx={{ width: 160, height: 160 }} /> {/* 랭크 이미지 */}
          <Box sx={{ display: 'flex', flexDirection: 'column', justifyContent: 'center' }}>
            <Typography variant="h5" sx={{ fontWeight: 'bold' }}>
              {(isTurbo || isNoPointTier(data.tier)) ? `${data.tier}` : `${data.tier} ${data.rank}`} {/* 랭크, 티어 텍스트 */}
            </Typography>

            {/* LP or 점수 */}
            {data.tier !== "랭크 없음" && (
              <Typography variant="h5">
                {isTurbo ? `${data.rank}점` : `${data.point}LP`} {/* isTurbo가 true면 점수, false면 LP 텍스트 */}
              </Typography>
            )}
          </Box>
        </Box>

        {/* 승패 수 */}
        {data.tier !== "랭크 없음" && (
          <Typography variant="h5" sx={{ mt: 1, textAlign: 'center' }}>
            {data.win}승 {data.lose}패 {/* 승패 수 텍스트 */}
          </Typography>
        )}
      </Box>
    );
  }
  //점수 표시 필요 없는 랭크 여부 확인하는 함수
  function isNoPointTier(tier) {
    return ["마스터", "그랜드마스터", "챌린저", "랭크 없음"].includes(tier);
  }

  return (
    <Box className='body'>
      {/* isInvalid가 true일 때(API 반환 값에 문제가 있을 때) */}
      <RiotAppBar /> {/* 상단 AppBar */}
      {isInvalid ? (
        <>
          <Box className="main" sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', mt: 5 }}>
            {/* 오류 메시지 */}
            <Typography variant="h4" sx={{ mb: 3 }}>
              잘못된 아이디 또는 태그입니다
            </Typography>

            {/* 자동완성, 검색창 박스 */}
            <Box component="form" onSubmit={handleSubmit} sx={{ width:700 }}>
              {/* 자동완성 */}
              <Autocomplete
                freeSolo // 자동 완성과 다른 값 입력 가능
                options={options} // 자동 완성 배열 설정
                disableClearable  // 초기화 버튼 비활성화
                value={autocompleteValue} // 검색창 값
                getOptionLabel={(option) => { // option 표시 
                  if (typeof option === "string") return option;
                  if (option.id && option.tag) return `${option.id}#${option.tag}`;
                  if (option.id) return option.id;
                  return "";
                }}
                onChange={(event, newValue) => { //newValue 값이 변경되었을 때 호출
                  if (!newValue) return;
                  let idValue = "";
                  let tagValue = "";
                  if (typeof newValue === "string") { // newValue의 타입이 string일때 실행
                    if (newValue.includes("#")) [idValue, tagValue = ""] = newValue.split("#"); // #을 포함할 때 #을 기점으로 앞은 id, 뒤는 tag로 설정
                    else idValue = newValue; // #을 포함하지 않을 때 
                  } else if (newValue.id && newValue.tag) { // newValue가 id,tag를 가지고 있는 객체일때 실행
                    idValue = newValue.id; tagValue = newValue.tag;
                  }
                  navigate(`/TFTRecord?id=${idValue}&tag=${tagValue}`); // TFTRecord로 매개변수 가지고 이동
                }}

                onInputChange={(event, newInputValue) => { //검색창 값이 변경되었을 때 호출
                  setAutocompleteValue(newInputValue);
                  handleInputChange(event, newInputValue);
                }}
                renderOption={(props, option) => ( // 자동완성 리스트 설정
                  <Box component="li" {...props} sx={{ display: "flex", alignItems: "center", gap: 1 }}> {/* 자동완성 리스트 박스 */}
                    {option.icon && ( // 자동완성 리스트 아이콘 설정
                      <Box
                        component="img"
                        src={option.icon}
                        alt="icon"
                        className="profileIcon"
                      />
                    )}
                    <Box>
                      <Typography sx={{ fontWeight: "bold", color: 'black' }}> {/* 자동완성 리스트 아이디, 태그 디자인 */}
                        {option.id}#{option.tag} {/* 자동완성 아이디, 태그 값 설정 */}
                      </Typography>
                      {option.regalia && ( // 자동완성 리스트 티어(설명) 디자인
                        <Typography sx={{ color: "rgb(70, 70, 70)", fontSize: 13 }}>
                          {option.regalia} {/* 자동완성 티어값 설정  */}
                        </Typography>
                      )}
                    </Box>
                  </Box>
                )}
                PaperComponent={(props) => ( //자동완성 리스트 스타일
                  <Box {...props} sx={{ backgroundColor: 'rgba(222, 222, 253, 1)' }} />
                )}
                renderInput={(params) => ( //검색창 설정
                  <TextField //검색창 디자인 설정
                    {...params}
                    label="아이디#태그"
                    variant="outlined"
                    fullWidth
                    sx={{
                      width: 700,
                      "& .MuiOutlinedInput-root": {
                        "& fieldset": { borderColor: "rgba(54, 45, 104, 1)", borderWidth: 3 },
                        "&:hover fieldset": { borderColor: "rgba(54, 45, 104, 1)" },
                        "&.Mui-focused fieldset": { borderColor: "rgba(24, 14, 78, 1)" },
                      }
                    }}
                    InputProps={{
                      ...params.InputProps,
                      endAdornment: (
                        <InputAdornment position="end"> {/* 검색 아이콘 설정 */}
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
      ) : data ? ( // isInvalid가 false고 data가 null이 아닐 때
        <>
          <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', mt: 5 }}>
            <Box sx={{ display: 'flex', alignItems: 'center', gap: 2, mb: 3, alignSelf: 'flex-start', ml: 25 }}> 
              <Box sx={{ position: 'relative', display: 'inline-block' }}> {/* 상단 */}
                <Box // 플레이어 아이콘 이미지
                  component="img"
                  src={data.playerProfileInfo.iconURL}
                  alt="playerProfileIcon"
                  sx={{ width: 100, height: 100, borderRadius: '50%', border: '2px solid rgba(24, 14, 78, 1)' }}
                />
                <Box // 플레이어 레벨 텍스트
                  sx={{
                    position: 'absolute',
                    bottom: 5,
                    left: '50%',
                    transform: 'translate(-50%, 50%)',
                    backgroundColor: 'rgba(87, 78, 126, 1)',
                    borderRadius: '20%',
                    border: '1px solid rgba(24, 14, 78, 1)',
                    p:'4px',
                    display: 'flex',
                    alignItems: 'center',
                    justifyContent: 'center',
                    fontWeight: 'bold',
                    fontSize: '0.75rem',
                  }}
                >
                  {data.playerProfileInfo.level}
                </Box>
              </Box>
              {/* 플레이어 아이디, 태그 */}
              <Box sx={{ display: 'flex', flexDirection: 'column', justifyContent: 'center', ml: 2 }}>
                <Typography variant="h4">
                  {data.playerProfileInfo.name}#{data.playerProfileInfo.tag}
                </Typography>
                {/* 전적 갱신 버튼 */}
                <Button
                  variant="outlined"
                  sx={{ mt: 2, width: 80, height: 45, color: 'rgb(200, 200, 200)', backgroundColor: 'rgba(24, 14, 78, 1)', border:'2px, solid, rgba(72, 98, 119, 1)' }}
                  onClick={() => window.location.reload()}
                >
                  갱신
                </Button>
              </Box>
            </Box>

            {/* 중단 */}
            <Box sx={{ display: 'flex', justifyContent: 'center', mb: 6, mt: 2, gap: 6, width: '80%',}}>
              <RegaliaBox // 랭크 박스
                title="랭크"
                data={data.playerRankInfo.rank}
                sx={{ width: '30%', height: 300 }}
              />
              <RegaliaBox // 더블 업 박스
                title="더블 업"
                data={data.playerRankInfo.doubleUp}
                sx={{ width: '30%', height: 300 }}
              />
              <RegaliaBox // 초고속 모드 박스
                title="초고속 모드"
                data={data.playerRankInfo.turbo}
                isTurbo
                sx={{ width: '30%', height: 300 }}
              />
            </Box>

            {/* 하단 */}
            <Box sx={{ width: '80%' }}>
              {data.matchInfo.map((match, idx) => ( // matchInfo 돌면서 모두 출력
                <TFTMatchAccordion key={idx} data={match} /> //매치 테이블
              ))}
            </Box>
          </Box>
        </>
      ) : ( //data가 null일 때
        <>
         {/* 스켈레톤 */}
          <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', }}>
            <Box sx={{ display: 'flex', alignItems: 'center', gap: 2, mb: 5, alignSelf: 'flex-start', ml: 25, mt:5 }}> {/* 상단: 아이콘 + 레벨 + 아이디/갱신 */}
              <Skeleton variant="circular" width={100} height={100} /> {/* 프로필 아이콘 */}             
              <Box sx={{ display: 'flex', flexDirection: 'column', justifyContent: 'center' }}> 
                <Skeleton variant="text" width={200} height={40} /> {/* 아이디 */}
                <Skeleton variant="rectangular" width={100} height={36} sx={{ mt: 1 }} />{/* 갱신 버튼 */}
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
                    height: 250
                  }}
                >
                  {/* 제목 */}
                  <Skeleton variant="text" width={80} height={30} sx={{ mb: 1 }} />

                  {/* 랭크 이미지 + 티어/LP */}
                  <Box sx={{ display: 'flex', alignItems: 'center', gap: 2, mb: 1 }}>
                    <Skeleton variant="rectangular" width={100} height={100} /> {/* 랭크 이미지 */}
                    <Box sx={{ display: 'flex', flexDirection: 'column', justifyContent: 'center' }}>
                      <Skeleton variant="text" width={80} height={24} /> {/* 랭크, 티어 텍스트 */}
                      <Skeleton variant="text" width={60} height={24} sx={{ mt: 0.5 }} /> {/* 점수 텍스트 */}
                    </Box>
                  </Box>

                  
                  <Skeleton variant="text" width={60} height={24} /> {/* 승패 텍스트 */}
                </Box>
              ))}
            </Box>

            {/* 매치 리스트 */}
            <Box sx={{ width: '80%' }}>
              {[1, 2, 3, 4, 5].map((i) => (
                <Box key={i} sx={{ display: 'flex', flexDirection: 'column', mb: 3 }}>
                  <Skeleton variant="rectangular" width="100%" height={170} /> {/* 매치 테이블 */}
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
