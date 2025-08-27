import { useState } from 'react';
import { Box, TextField, Button, Typography, Container, Alert } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import RiotAppBar from './RiotAppBar';
import axios from 'axios';
import './reset.css';
import './index.css';

function SignUpPage() {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    id: '',
    email: '',
    password: '',
    confirmPassword: '',
    riotAccount: ''
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

    if (!formData.id || !formData.email || !formData.password || !formData.confirmPassword) {
      setError('모든 필드를 입력해주세요.');
      return;
    }

    if (formData.password !== formData.confirmPassword) {
      setError('비밀번호가 일치하지 않습니다.');
      return;
    }
    try {
      const response = await axios.get('http://localhost:8080/db/findAccountDBbyID', {
        params: { id: formData.id }
      });
      console.log(response.data);
      if (response.data) {
        setError('이미 존재하는 아이디입니다.');
        return;
      }

      console.log('회원가입 데이터:', formData);
      await axios.post('http://localhost:8080/db/addAccountDB', {
        id:formData.id,
        pw:formData.password,
        email:formData.email,
        riotAccount:formData.riotAccount,
      });

      setSuccess('회원가입이 완료되었습니다!');
      setFormData({ id: '', email: '', password: '', confirmPassword: '', riotAccount: '' });
      navigate(`/`);
    } catch (error) {
      console.error('DB 체크 오류:', error);
      setError('서버 오류가 발생했습니다.');
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
            회원가입
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
              autoComplete="off"
              name="password"
              type="password"
              value={formData.password}
              onChange={handleChange}
              fullWidth
              margin="normal"
              InputLabelProps={{ sx: { color: 'rgba(170,170,170,0.7)' } }}
              sx={textFieldSx}
            />
            <TextField
              label="비밀번호 확인"
              autoComplete="off"
              name="confirmPassword"
              type="password"
              value={formData.confirmPassword}
              onChange={handleChange}
              fullWidth
              margin="normal"
              InputLabelProps={{ sx: { color: 'rgba(170,170,170,0.7)' } }}
              sx={textFieldSx}
            />
            <TextField
              label="이메일"
              autoComplete="off"
              name="email"
              type="email"
              value={formData.email}
              onChange={handleChange}
              fullWidth
              margin="normal"
              InputLabelProps={{ sx: { color: 'rgba(170,170,170,0.7)' } }}
              sx={textFieldSx}
            />
            <TextField
              label="라이엇 계정명(아이디#태그)"
              autoComplete="off"
              name="riotAccount"
              value={formData.riotAccount}
              onChange={handleChange}
              fullWidth
              margin="normal"
              InputLabelProps={{ sx: { color: 'rgba(170,170,170,0.7)' } }}
              sx={textFieldSx}
            />
            <Button
              type="submit"
              variant="contained"
              color="primary"
              fullWidth
              sx={{ mt: 3, py: 1.5 }}
            >
              회원가입
            </Button>
          </Box>
        </Box>
      </Container>
    </Box>
  );
}

export default SignUpPage;
