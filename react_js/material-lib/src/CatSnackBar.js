import React, { useState } from 'react';
import Button from '@mui/material/Button';
import Snackbar from '@mui/material/Snackbar';
import Alert from '@mui/material/Alert';

export default function CatSnackBar() {
  const [open, setOpen] = useState(false);

  // 알림 열기
  const handleClick = () => {
    setOpen(true);
  };

  // 자동 닫기 or 수동 닫기 이벤트
  const handleClose = (event, reason) => {
    if (reason === 'clickaway') return; // 바깥 클릭 무시
    setOpen(false);
  };

  return (
    <>
      {/* 버튼 눌러서 알림 띄우기 */}
      <Button variant="outlined" onClick={handleClick}>
        저장하기
      </Button>

      {/* Snackbar: 알림창 */}
      {/* open: 열림 여부 / autoHideDuration: 자동 닫기 시간 (ms) */}
      <Snackbar
        open={open}
        autoHideDuration={3000}
        onClose={handleClose}
        anchorOrigin={{ vertical: 'bottom', horizontal: 'center' }}
      >
        {/* Alert: 메시지 스타일 지정 (severity: info/success/warning/error) */}
        <Alert onClose={handleClose} severity="success" sx={{ width: '100%' }}>
          저장 완료!
        </Alert>
      </Snackbar>
    </>
  );
}
