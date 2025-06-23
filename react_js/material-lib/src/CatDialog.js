import React, { useState } from 'react';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';

export default function CatDialog() {
  const [open, setOpen] = useState(false);

  // 열기/닫기 함수
  const handleClickOpen = () => {
    setOpen(true);
  };
  const handleClose = () => {
    setOpen(false);
  };

  // 확인 클릭 시
  const handleConfirm = () => {
    alert('삭제 완료!');
    setOpen(false);
  };

  return (
    <div>
      {/* 버튼 클릭으로 다이얼로그 열기 */}
      <Button variant="outlined" onClick={handleClickOpen}>
        삭제 요청
      </Button>

      {/* Dialog: 팝업창 */}
      <Dialog open={open} onClose={handleClose}>
        {/* 제목 영역 */}
        <DialogTitle>고양이 삭제</DialogTitle>

        {/* 본문 설명 영역 */}
        <DialogContent>
          <DialogContentText>
            이 고양이 정보를 정말 삭제하시겠습니까? 이 작업은 되돌릴 수 없습니다.
          </DialogContentText>
        </DialogContent>

        {/* 버튼 영역 */}
        <DialogActions>
          <Button onClick={handleClose}>취소</Button>
          <Button onClick={handleConfirm} autoFocus>
            확인
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}
