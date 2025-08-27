import { useContext } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import { AppBar, Toolbar, Typography, TextField, Box } from '@mui/material';
import { UserContext } from './UserContext';
import './reset.css';

function RiotAppBar() {
  const navigate = useNavigate();
  const { setUserId, setIsLoggedIn, setRiotAccount, isLoggedIn, userId } = useContext(UserContext); //전역 변수 사용
  const location = useLocation(); 

  const isActive = (path) => location.pathname === path;
  return (
    <AppBar position="static" sx={{ backgroundColor: 'rgba(24, 14, 78, 1)' }}>
      <Toolbar sx={{ display: 'flex', alignItems: 'center', gap: 5 }}>

        {/* 메인 페이지로 이동 버튼 */}
        <Typography variant="h6" onClick={() => navigate(`/`)} sx={{ cursor: 'pointer' }}>
          라이엇 전적 검색
        </Typography>

        {/* 리그 오브 레전드 메인 페이지로 이동 버튼 */}
        <Typography variant="h6" onClick={() => navigate(`/LOLMain`)} sx={{ cursor: 'pointer', backgroundColor: isActive('/LOLMain') ? 'rgba(87, 78, 126, 1)' : 'transparent', padding: '12px' }}>
          리그 오브 레전드
        </Typography>

        {/* 전략적 팀 전투 메인 페이지로 이동 버튼 */}
        <Typography variant="h6" onClick={() => navigate(`/TFTMain`)} sx={{ cursor: 'pointer', backgroundColor: isActive('/TFTMain') ? 'rgba(87, 78, 126, 1)' : 'transparent', padding: '12px', }} >
          전략적 팀 전투
        </Typography>

        {/* 발로란트 메인 페이지로 이동 버튼 */}
        <Typography variant="h6" onClick={() => navigate(`/VALMain`)} sx={{ cursor: 'pointer', backgroundColor: isActive('/VALMain') ? 'rgba(87, 78, 126, 1)' : 'transparent', padding: '12px', }}>
          발로란트
        </Typography>

        {/* 커뮤니티 메인 페이지로 이동 버튼 */}
        <Typography variant="h6" onClick={() => navigate(`/COMMain`)} sx={{ cursor: 'pointer', backgroundColor: isActive('/COMMain') ? 'rgba(87, 78, 126, 1)' : 'transparent', padding: '12px', }}>
          커뮤니티
        </Typography>
        <Box sx={{ flexGrow: 1 }} />

        {/* AppBar 검색창 */}
        <TextField variant="outlined" size="small" placeholder="아이디#태그" sx={{ backgroundColor: 'white', borderRadius: 1, mr: 2, width: '250px' }}/>

        {/* 로그인, 회원가입, 마이 페이지 */}
        {!isLoggedIn ? ( //비로그인 시
          <>
            {/* 로그인 페이지로 이동 버튼 */}
            <Typography
              variant="h6"
              onClick={() => navigate(`/SignInPage`)}
              sx={{
                cursor: 'pointer',
                backgroundColor: isActive('/SignInPage') ? 'rgba(87, 78, 126, 1)' : 'transparent',
                padding: '12px',
              }}
            >
              로그인
            </Typography>

        {/* 회원가입 페이지로 이동 버튼 */}
            <Typography
              variant="h6"
              onClick={() => navigate(`/SignUpPage`)}
              sx={{
                cursor: 'pointer',
                backgroundColor: isActive('/SignUpPage') ? 'rgba(87, 78, 126, 1)' : 'transparent',
                padding: '12px',
              }}
            >
              회원가입
            </Typography>
          </>
        ) : //로그인 시
        <>
            {/* 로그아웃 버튼 */}
            <Typography
              variant="h6"
              onClick={() => {
                setIsLoggedIn(false);
                setUserId('');
                setRiotAccount('');
                localStorage.clear();
                console.log("로그아웃")
              }}
              sx={{
                cursor: 'pointer',
                backgroundColor: 'transparent',
                padding: '12px',
              }}
            >
              로그아웃
            </Typography>

        {/* 마이 페이지로 이동 버튼*/}
            <Typography
              variant="h6"
              onClick={() => navigate(`/MyPage`)}
              sx={{
                cursor: 'pointer',
                backgroundColor: isActive('/MyPage') ? 'rgba(87, 78, 126, 1)' : 'transparent',
                padding: '12px',
              }}
            >
              {userId}
            </Typography>
          </>
        }

      </Toolbar>

    </AppBar>
  );
}

export default RiotAppBar;
