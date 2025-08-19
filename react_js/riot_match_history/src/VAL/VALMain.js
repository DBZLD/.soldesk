import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import RiotAppBar from '.././RiotAppBar';
import { Box, TextField, IconButton, InputAdornment } from '@mui/material';
import SearchIcon from "@mui/icons-material/Search";

import '../reset.css';
import '../index.css';
import './VALcommon.css';

function VALMain() {
  const navigate = useNavigate();
  const [id, setId] = useState('');
  const [tag, setTag] = useState('');

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
    } else{
      setId(inputString);
      setTag('');
    }
  };
  return (
    <div className='body'>
      <RiotAppBar/>
      <div className='main'>
        <div className='title'>VAL 전적 검색</div>
          <Box
            component="form"
            onSubmit={handleSubmit}
            sx={{ display: "flex", alignItems: "center", mb: 3 }}
          >
          <TextField
            label="아이디#태그"
            variant="outlined"
            onChange={handleInputChange}
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
    </div>
  );
}

export default VALMain;