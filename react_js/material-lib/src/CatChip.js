import React from 'react';
import Chip from '@mui/material/Chip';
import Stack from '@mui/material/Stack';
import FaceIcon from '@mui/icons-material/Face';

export default function CatChip() {
  return (
    <Stack direction="row" spacing={1}>
      {/* 기본 칩 */}
      <Chip label="고양이" />

      {/* 색상 있는 칩 */}
      <Chip label="SSR" color="primary" />

      {/* 아이콘 포함 칩 */}
      <Chip icon={<FaceIcon />} label="프로필" />

      {/* 삭제 가능한 칩 */}
      <Chip
        label="삭제 가능"
        onDelete={() => alert('삭제 클릭됨')}
      />

      {/* 삭제 아이콘 커스터마이징 */}
      <Chip
        label="X 아이콘 변경"
        deleteIcon={<FaceIcon />}
        onDelete={() => alert('아이콘 삭제 클릭')}
      />
    </Stack>
  );
}
