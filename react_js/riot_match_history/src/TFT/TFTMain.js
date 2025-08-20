import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import RiotAppBar from '.././RiotAppBar';
import { Box, IconButton, InputAdornment, Autocomplete, TextField } from '@mui/material';
import SearchIcon from "@mui/icons-material/Search";
import axios from 'axios';
import '../reset.css';
import '../index.css';
import './TFTcommon.css';

function TFTMain() {
  const navigate = useNavigate();

  const [id, setId] = useState('');
  const [tag, setTag] = useState('');
  const [options, setOptions] = useState([]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    navigate(`/TFTRecord?id=${id}&tag=${tag}`);
  };

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

  return (
    <div className='body'>
      <RiotAppBar />
      <div className='main'>
        <div className='title'>TFT 전적 검색</div>
        <Box
          component="form"
          onSubmit={handleSubmit}
          sx={{ display: "flex", alignItems: "center", mb: 3 }}
        >
          <Autocomplete
            freeSolo
            options={options}
            disableClearable
            getOptionLabel={(option) => {
              if (typeof option === "string") return option;
              if (option.id && option.tag) return `${option.id}#${option.tag}`;
              if (option.id) return option.id;
              return "";
            }}
            onChange={(event, newValue) => {
              if (!newValue) return;

              // 옵션 클릭 시 id, tag 분리
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
            onInputChange={handleInputChange}
            renderOption={(props, option) => (
              <Box
                component="li"
                {...props}
                sx={{
                  display: "flex",
                  alignItems: "center",
                  gap: 1,
                }}
              >
                {option.icon && (
                  <img
                    src={option.icon}
                    alt="icon"
                    style={{ width: 32, height: 32, borderRadius: "50%" }}
                  />
                )}
                <Box>
                  <div style={{ fontWeight: "bold" }}>
                    {option.id}#{option.tag}
                  </div>
                  {option.regalia && (
                    <div style={{ fontSize: "0.8rem", color: "gray" }}>
                      {option.regalia}
                    </div>
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
                  ...params.inputProps,
                  sx: {
                    height: 40,
                    color: "rgb(170, 170, 170)",
                  },
                }}
                InputProps={{
                  ...params.InputProps,
                  endAdornment: (
                    <>
                      <InputAdornment position="end">
                        <IconButton type="submit">
                          <SearchIcon sx={{ color: "rgba(54, 45, 104, 1)" }} />
                        </IconButton>
                      </InputAdornment>
                    </>
                  ),
                }}
              />
            )}
          />
        </Box>
      </div>
    </div>
  );
}

export default TFTMain;
