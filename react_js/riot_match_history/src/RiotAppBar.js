import React from 'react';
import { AppBar, Toolbar, Typography, Button, TextField } from '@mui/material';
import MiniAppBar from './MiniAppBar';
import './common.css';

function RiotAppBar() {
  return (
    <AppBar position="static">
      <Toolbar>
        <Typography variant="h6" sx={{ flexGrow: 1 }}>
          라이엇 전적 검색
        </Typography>

        <TextField
          variant="outlined"
          size="small"
          placeholder="아이디#태그"
          sx={{ backgroundColor: 'white', borderRadius: 1, mr: 2, width: '250px' }}
        />

        <Button color="inherit">로그인</Button>
        <Button color="inherit">회원가입</Button>
      </Toolbar>
      <MiniAppBar/>
    </AppBar>
  );
}

export default RiotAppBar;
