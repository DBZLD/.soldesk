import React from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import { AppBar, Toolbar, Typography, Button, TextField, Box } from '@mui/material';
import MiniAppBar from './MiniAppBar';
import './reset.css';

function RiotAppBar(page) {
  const navigate = useNavigate();
  const location = useLocation(); // 현재 경로 확인용

  const isActive = (path) => location.pathname === path;

  return (
    <AppBar position="static" sx={{ backgroundColor: 'rgba(24, 14, 78, 1)' }}>
      <Toolbar sx={{ display: 'flex', alignItems: 'center', gap: 5 }}>
        <Typography
          variant="h6"
          onClick={() => navigate(`/`)}
          sx={{ cursor: 'pointer' }}
        >
          라이엇 전적 검색
        </Typography>

        <Typography
          variant="h6"
          onClick={() => navigate(`/LOLMain`)}
          sx={{
            cursor: 'pointer',
            backgroundColor: isActive('/LOLMain') ? 'rgba(87, 78, 126, 1)' : 'transparent',
            padding: '12px'
          }}
        >
          리그 오브 레전드
        </Typography>

        <Typography
          variant="h6"
          onClick={() => navigate(`/TFTMain`)}
          sx={{
            cursor: 'pointer',
            backgroundColor: isActive('/TFTMain') ? 'rgba(87, 78, 126, 1)' : 'transparent',
            padding: '12px',
          }}
        >
          전략적 팀 전투
        </Typography>

        <Typography
          variant="h6"
          onClick={() => navigate(`/VALMain`)}
          sx={{
            cursor: 'pointer',
            backgroundColor: isActive('/VALMain') ? 'rgba(87, 78, 126, 1)' : 'transparent',
            padding: '12px',
          }}
        >
          발로란트
        </Typography>

        <Typography
          variant="h6"
          onClick={() => navigate(`/COMMain`)}
          sx={{
            cursor: 'pointer',
            backgroundColor: isActive('/COMMain') ? 'rgba(87, 78, 126, 1)' : 'transparent',
            padding: '12px',
          }}
        >
          커뮤니티
        </Typography>

        <Box sx={{ flexGrow: 1 }} />

        <TextField
          variant="outlined"
          size="small"
          placeholder="아이디#태그"
          sx={{ backgroundColor: 'white', borderRadius: 1, mr: 2, width: '250px' }}
        />

        <Button color="inherit" onClick={() => navigate(`/SignInPage`)}>로그인</Button>
        <Button color="inherit" onClick={() => navigate(`/SignUpPage`)}>회원가입</Button>
      </Toolbar>

      <MiniAppBar pg={page} />
    </AppBar>
  );
}

export default RiotAppBar;
