import React, { useState } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Checkbox from '@mui/material/Checkbox';
import FormControlLabel from '@mui/material/FormControlLabel';
import Typography from '@mui/material/Typography';

export default function CatForm() {
  // 폼 상태 관리
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [agree, setAgree] = useState(false);

  // 제출 시 동작
  const handleSubmit = (e) => {
    e.preventDefault();
    alert(`이름: ${name}\n이메일: ${email}\n약관 동의: ${agree}`);
  };

  return (
    <Box
      component="form"
      onSubmit={handleSubmit}
      sx={{
        '& .MuiTextField-root': { m: 1, width: '300px' },
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        p: 2,
      }}
    >
      {/* 제목 */}
      <Typography variant="h6">회원 정보 입력</Typography>

      {/* 이름 입력 필드 */}
      <TextField
        required
        label="이름"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />

      {/* 이메일 입력 필드 */}
      <TextField
        required
        label="이메일"
        type="email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />

      {/* 약관 동의 체크박스 */}
      <FormControlLabel
        control={
          <Checkbox
            checked={agree}
            onChange={(e) => setAgree(e.target.checked)}
          />
        }
        label="약관에 동의합니다."
      />

      {/* 제출 버튼 */}
      <Button type="submit" variant="contained" color="primary" disabled={!agree}>
        제출
      </Button>
    </Box>
  );
}
