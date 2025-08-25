// TFTMain.jsx
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import RiotAppBar from '.././RiotAppBar';
import { Box, IconButton, InputAdornment, Autocomplete, TextField, Typography } from '@mui/material';
import SearchIcon from "@mui/icons-material/Search";
import axios from 'axios';
import '../reset.css';
import '../index.css';
import './TFTcommon.css';

function TFTMain() {
  const navigate = useNavigate();

  const [id, setId] = useState('');
  const [tag, setTag] = useState('');  
  const [options, setOptions] = useState([]); // SearchDb 데이터

  // 검색 시 실행되는 함수
  const handleSubmit = async (e) => {
    e.preventDefault();
    navigate(`/TFTRecord?id=${id}&tag=${tag}`); // 매개변수 전달하면서 TFTRecord 페이지로 이동
  };

  // 검색 내용 변경시 실행되는 함수
  const handleInputChange = async (e, newValue) => {
    let idValue = "";
    let tagValue = "";

    if (typeof newValue === "string") {
      if (newValue.includes('#')) { // #을 포함할 시
        [idValue, tagValue = ""] = newValue.split('#'); // #을 기점으로 앞은 아이디로 뒤는 태그로 할당
      } else {  // # 미포함 시
        idValue = newValue; // 전체를 아이디로 할당
        tagValue = '';      // 태그는 빈 값
      }
      setId(idValue);   
      setTag(tagValue);

      try { 
        const response = await axios.get('http://localhost:8080/db/getSearchDB', {  // spring에 DB에 접속하는 함수 호출 요청
          params: { id: idValue, tag: tagValue }  // 매개변수로 id, tag 전달
        });
        setOptions(response.data);  // options 값에 받아온 데이터 할당
      } catch (error) { // 에러 발생 시
        console.error("DB 저장 실패:", error); //DB 저장 실패 에러 출력
      }
    }
  };

  return (
    <Box className="body"> {/* 페이지 전체 박스 */}
      <RiotAppBar /> {/* 상단 Appbar */}
      <Box className="main" sx={{ textAlign: "center", mt: 5 }}> {/* 페이지 메인 박스 */}
        <Typography variant="h2" sx={{ fontWeight: 700, mb: 3 }}> {/* 페이지 타이틀 */}
          TFT 전적 검색
        </Typography>

        <Box component="form" onSubmit={handleSubmit} sx={{ display: "flex", justifyContent: "center", mb: 5 }}> {/* 페이지 검색 박스 */}
          {/* 자동완성 */}
          <Autocomplete 
            freeSolo // 자동 완성과 다른 값 입력 가능
            options={options} // 자동 완성 배열 설정
            disableClearable  // 초기화 버튼 비활성화

            getOptionLabel={(option) => { // option 표시 
              if (typeof option === "string") return option;
              if (option.id && option.tag) return `${option.id}#${option.tag}`;
              if (option.id) return option.id;
              return "";
            }}
            onChange={(event, newValue) => { // 검색 창 내용 변경 시 
              if (!newValue) return; // newValue가 존재하지 않을 시 종료 
              let idValue = "";   
              let tagValue = "";

              if (typeof newValue === "string") { // newValue의 타입이 string일때만 실행
                if (newValue.includes("#")) {// #을 포함할 때
                  [idValue, tagValue = ""] = newValue.split("#"); // #을 기점으로 앞은 id, 뒤는 tag로 설정
                } else { // #을 포함하지 않을 때 
                  idValue = newValue;
                  tagValue = "";
                }
              } else if (newValue.id && newValue.tag) { // newValue가 id, tag를 포함한 객체 형태로 들어왔을 때
                idValue = newValue.id;
                tagValue = newValue.tag;
              }
              navigate(`/TFTRecord?id=${idValue}&tag=${tagValue}`); // 매개변수 전달하면서 TFTRecord 페이지로 이동
            }}
            onInputChange={handleInputChange} // 입력 값 변경 시
            renderOption={(props, option) => ( // 자동완성 리스트 설정
              <Box component="li" {...props} sx={{ display: "flex", alignItems: "center", gap: 1 }}> {/* 자동완성 리스트 박스 */}
                {option.icon && ( // 자동완성 리스트 아이콘 설정
                  <img
                    src={option.icon}
                    alt="icon"
                    className="profileIcon"
                  />
                )}
                <Box>
                  <Typography sx={{ fontWeight: "bold", color:'black' }}> {/* 자동완성 리스트 아이디, 태그 설정 */}
                    {option.id}#{option.tag}
                  </Typography>
                  {option.regalia && ( // 자동완성 리스트 티어(설명) 설정
                    <Typography variant="body2" color="rgb(70, 70, 70)">
                      {option.regalia}
                    </Typography>
                  )}
                </Box>
              </Box>
            )}
            PaperComponent={(props) => ( //자동완성 리스트 스타일
              <Box {...props} sx={{ backgroundColor: 'rgba(202, 202, 255, 1)' }} />
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
                        <SearchIcon sx={{ color:"rgba(54, 45, 104, 1)" }}/>
                      </IconButton>
                    </InputAdornment>
                  ),
                }}
              />
            )}
          />
        </Box>
      </Box>
    </Box>
  );
}

export default TFTMain;
