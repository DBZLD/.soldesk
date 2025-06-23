import React from 'react';
import Tooltip from '@mui/material/Tooltip';
import IconButton from '@mui/material/IconButton';
import InfoIcon from '@mui/icons-material/Info';

export default function CatTooltip() {
  return (
    // Tooltip: 호버 시 나타날 내용(title 속성처럼 사용됨)
    <Tooltip title="고양이에 대한 정보 보기" arrow placement="right">
      {/* Tooltip을 적용할 대상 컴포넌트 */}
      <IconButton aria-label="info">
        <InfoIcon />
      </IconButton>
    </Tooltip>
  );
}
