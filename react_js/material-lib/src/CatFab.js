import React from 'react';
import Fab from '@mui/material/Fab';
import AddIcon from '@mui/icons-material/Add';
import Tooltip from '@mui/material/Tooltip';

export default function CatFab() {
  // 클릭 이벤트 핸들러
  const handleClick = () => {
    alert('고양이 추가!');
  };

  return (
    // Tooltip: 마우스 올렸을 때 설명 문구
    <Tooltip title="고양이 추가" placement="left">
      {/* Fab: 플로팅 버튼 / color, size, aria-label 지정 가능 */}
      <Fab
        color="secondary"
        aria-label="add"
        onClick={handleClick}
        sx={{
          position: 'fixed',
          bottom: 16,
          right: 16,
        }}
      >
        {/* AddIcon: ➕ 아이콘 */}
        <AddIcon />
      </Fab>
    </Tooltip>
  );
}
