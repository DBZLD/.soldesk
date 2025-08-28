import { useState, useContext } from 'react';
import { Box, TextField, Button, Typography, Container, Alert } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import { UserContext } from './UserContext';
import RiotAppBar from '../Util/RiotAppBar';
import axios from 'axios';
import './reset.css';
import './index.css';

const SignInPage = () => {
  const navigate = useNavigate();
  const { setUserId, setIsLoggedIn, setRiotAccount } = useContext(UserContext); //전역 변수 사용

  const [formData, setFormData] = useState({ id: '', password: '' });
  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');

  // 입력값이 바뀔때마다 실행
  const handleChange = (e) => { 
    setFormData({ ...formData, [e.target.name]: e.target.value }); // target.name에 target.value를 할당
    setError('');
    setSuccess('');
  };

  //로그인 버튼 누를시 실행
  const handleSubmit = async (e) => {
    e.preventDefault(); // submit 기본 행동 비활성화

    // 아이디, 비밀번호 null일시
    if (!formData.id || !formData.password) {
      setError('아이디 또는 비밀번호를 입력해주세요.');
      return;
    }

    // AccountDB에서 id, pw 일치하는 값 찾기
    try {
      const response = await axios.get('http://localhost:8080/db/findAccountDB', {
        params: {
          id: formData.id,
          pw: formData.password
        }
      });

      if (response.data) { // id, pw가 일치하는 정보가 AccountDB에 있을 시
        console.log('로그인 성공:', formData);
        setIsLoggedIn(true);
        setUserId(response.data.id);
        setRiotAccount(response.data.riotAccount || '');

        setSuccess('로그인 성공!');
        setError('');
        navigate(`/`);
      } else { // id, pw가 일치하는 정보가 AccountDB에 없을 시
        setError('아이디 또는 비밀번호가 일치하지 않습니다.');
        setIsLoggedIn(false);
        setSuccess('');
      }

    } catch (err) { // 오류 발생 시
      console.error('로그인 오류:', err);
      setError('서버 오류가 발생했습니다.');
      setSuccess('');
    }
  };

  const textFieldSx = { // textField 디자인
    '& .MuiInputBase-input': { color: 'rgb(200,200,200)' },
    '& .MuiOutlinedInput-root': {
      "& fieldset": { borderColor: "rgba(54, 45, 104, 1)", borderWidth: 3 },
      "&:hover fieldset": { borderColor: "rgba(54, 45, 104, 1)" },
      "&.Mui-focused fieldset": { borderColor: "rgba(24, 14, 78, 1)" },
    },
  };

  return (
    <Box className = 'body'>
      <RiotAppBar /> {/* 상단 AppBar */}
      <Container maxWidth="sm" sx={{ mt: 5 }}>
        {/* 로그인 박스 */}
        <Box
          sx={{
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            backgroundColor: 'rgba(70, 70, 70, 1)',
            color: 'rgb(170, 170, 170)',
            padding: 4,
            boxShadow: 3,
            borderRadius: 2,
          }}
        >
          {/* 로그인 타이틀 */}
          <Typography variant="h4" component="h1" gutterBottom>
            로그인
          </Typography>

          {error && <Alert severity="error" sx={{ mb: 2, width: '100%' }}>{error}</Alert>} {/* 에러 메세지 */}
          {success && <Alert severity="success" sx={{ mb: 2, width: '100%' }}>{success}</Alert>} {/* 성공 메세지 */}

          {/* 아이디 입력 창 */}
          <Box component="form" onSubmit={handleSubmit} sx={{ width: '100%' }}>
            <TextField
              label="아이디"
              name="id"
              autoComplete="off"
              value={formData.id}
              onChange={handleChange}
              fullWidth
              margin="normal"
              InputLabelProps={{ sx: { color: 'rgba(170,170,170,0.7)' } }}
              sx={textFieldSx}
            />
            {/* 비밀번호 입력 창 */}
            <TextField
              label="비밀번호"
              name="password"
              type="password"
              autoComplete="off"
              value={formData.password}
              onChange={handleChange}
              fullWidth
              margin="normal"
              InputLabelProps={{ sx: { color: 'rgba(170,170,170,0.7)' } }}
              sx={textFieldSx}
            />
            {/* 로그인 버튼 */}
            <Button
              type="submit"
              variant="contained"
              fullWidth
              sx={{ mt: 3, py: 1.5, backgroundColor: 'rgba(24, 14, 78, 1)' }}
            >
              로그인
            </Button>
          </Box>
        </Box>
      </Container>
    </Box>
  );
};

export default SignInPage;
