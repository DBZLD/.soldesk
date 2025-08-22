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
        const response = await axios.get('http://localhost:8080/db/getSearchDB', {
          params: { id: idValue, tag: tagValue }
        });
        setOptions(response.data);
      } catch (error) {
        console.error("DB 저장 실패:", error);
      }
    }
  };

  return (
    <Box className="body">
      <RiotAppBar />
      <Box className="main" sx={{ textAlign: "center", mt: 5 }}>
        <Typography variant="h2" sx={{ fontWeight: 700, mb: 3 }}>
          TFT 전적 검색
        </Typography>

        {/* 검색창 */}
        <Box component="form" onSubmit={handleSubmit} sx={{ display: "flex", justifyContent: "center", mb: 5 }}>
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
              navigate(`/TFTRecord?id=${idValue}&tag=${tagValue}`);
            }}
            onInputChange={handleInputChange}
            renderOption={(props, option) => (
              <Box component="li" {...props} sx={{ display: "flex", alignItems: "center", gap: 1 }}>
                {option.icon && (
                  <img
                    src={option.icon}
                    alt="icon"
                    className="profileIcon"
                  />
                )}
                <Box>
                  <Typography sx={{ fontWeight: "bold", color:'rgb(70, 70, 70)' }}>
                    {option.id}#{option.tag}
                  </Typography>
                  {option.regalia && (
                    <Typography variant="body2" color="gray">
                      {option.regalia}
                    </Typography>
                  )}
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
                    <InputAdornment position="end">
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
