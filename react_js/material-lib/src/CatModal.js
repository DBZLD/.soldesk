import React, { useState } from 'react';
import Button from '@mui/material/Button';
import Modal from '@mui/material/Modal';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';

export default function CatModal() {
  // 모달 열림 여부 상태
  const [open, setOpen] = useState(false);

  // 모달 열기
  const handleOpen = () => setOpen(true);

  // 모달 닫기
  const handleClose = () => setOpen(false);

  // 모달 스타일 정의
  const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 300,
    bgcolor: 'background.paper',
    border: '2px solid #888',
    boxShadow: 24,
    p: 4,
    borderRadius: 2,
  };

  return (
    <div>
      {/* 버튼 클릭 시 모달 열림 */}
      <Button onClick={handleOpen} variant="contained">고양이 정보 보기</Button>

      {/* Modal: 팝업 창 */}
      {/* open: 상태로 열림 여부 제어 / onClose: 닫기 이벤트 */}
      <Modal open={open} onClose={handleClose}>
        <Box sx={style}>
          <Typography variant="h6" component="h2">
            🐱 고양이 정보
          </Typography>
          <Typography sx={{ mt: 2 }}>
            이 고양이는 평범하지만 귀엽습니다.  
            훈련을 통해 SR 등급까지 성장 가능!
          </Typography>
        </Box>
      </Modal>
    </div>
  );
}
