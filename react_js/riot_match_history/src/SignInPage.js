import { useState, useContext } from 'react';
import { Box, TextField, Button, Typography, Container, Alert } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import { UserContext } from './UserContext';
import RiotAppBar from './RiotAppBar';
import axios from 'axios';

const SignInPage = () => {
  const navigate = useNavigate();
  const { setUserId, setIsLoggedIn, setRiotAccount } = useContext(UserContext);

  const [formData, setFormData] = useState({
    id: '',
    password: ''
  });

  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
    setError('');
    setSuccess('');
  };

const handleSubmit = async (e) => {
  e.preventDefault();

  if (!formData.id || !formData.password) {
    setError('아이디 또는 비밀번호를 입력해주세요.');
    return;
  }

  try {
    const response = await axios.get('http://localhost:8080/db/findAccountDB', {
      params: {
        id: formData.id,
        pw: formData.password
      }
    });

    if (response.data) {
      console.log('로그인 성공:', formData);
      setIsLoggedIn(true);
      setUserId(response.data.id);
      setRiotAccount(response.data.riotAccount || '');

      setSuccess('로그인 성공!');
      setError('');
      navigate(`/`);
    } else {
      setError('아이디 또는 비밀번호가 일치하지 않습니다.');
      setIsLoggedIn(false);
      setSuccess('');
    }

  } catch (err) {
    console.error('로그인 오류:', err);
    setError('서버 오류가 발생했습니다.');
    setSuccess('');
  }
};

  const textFieldSx = {
    '& .MuiInputBase-input': { color: 'rgb(200,200,200)' },
    '& .MuiOutlinedInput-root': {
      "& fieldset": { borderColor: "rgba(54, 45, 104, 1)", borderWidth: 3 },
      "&:hover fieldset": { borderColor: "rgba(54, 45, 104, 1)" },
      "&.Mui-focused fieldset": { borderColor: "rgba(24, 14, 78, 1)" }, 
    },
  };

  return (
    <Box sx={{ minHeight: '100vh', backgroundColor: 'rgb(41, 41, 41)' }}>
      <RiotAppBar />
      <Container maxWidth="sm" sx={{ mt: 5 }}>
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
          <Typography variant="h4" component="h1" gutterBottom>
            로그인
          </Typography>

          {error && <Alert severity="error" sx={{ mb: 2, width: '100%' }}>{error}</Alert>}
          {success && <Alert severity="success" sx={{ mb: 2, width: '100%' }}>{success}</Alert>}

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
            <Button
              type="submit"
              variant="contained"
              fullWidth
              sx={{ mt: 3, py: 1.5 }}
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
