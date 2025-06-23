import React, { useState } from 'react';
import Popover from '@mui/material/Popover';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';

export default function CatPopover() {
  // Popover 열릴 기준 요소 저장
  const [anchorEl, setAnchorEl] = useState(null);

  // 열기: 클릭한 버튼을 anchor로 지정
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  // 닫기: anchor를 null로 초기화
  const handleClose = () => {
    setAnchorEl(null);
  };

  // Popover 열림 여부 판단
  const open = Boolean(anchorEl);
  const id = open ? 'cat-popover' : undefined;

  return (
    <div>
      {/* 버튼 클릭하면 Popover 열림 */}
      <Button variant="contained" aria-describedby={id} onClick={handleClick}>
        더 보기
      </Button>

      {/* Popover: 흰 배경의 콘텐츠 박스 */}
      <Popover
        id={id}
        open={open}
        anchorEl={anchorEl}       // 기준 요소
        onClose={handleClose}     // 바깥 클릭 시 닫힘
        anchorOrigin={{          // Popover 위치 기준 (버튼 아래)
          vertical: 'bottom',
          horizontal: 'left',
        }}
        transformOrigin={{       // 팝업 아이들의 기준점 (위에서부터)
          vertical: 'top',
          horizontal: 'left',
        }}
      >
        {/* 실제 내용 영역 */}
        <Box p={2}>
          <Typography sx={{ mb: 1 }}>추가 정보</Typography>
          <Typography variant="body2">
            고양이 관련 상세 정보를 여기에 넣을 수 있어요.
          </Typography>
        </Box>
      </Popover>
    </div>
  );
}
