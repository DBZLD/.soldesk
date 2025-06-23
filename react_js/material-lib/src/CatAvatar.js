import React from 'react';
import Avatar from '@mui/material/Avatar';
import Badge from '@mui/material/Badge';
import Stack from '@mui/material/Stack';

export default function CatAvatar() {
  return (
    <Stack direction="row" spacing={2} alignItems="center">
      {/* 기본 아바타: 글자 이니셜 */}
      <Avatar>A</Avatar>

      {/* 이미지 아바타 */}
      <Avatar alt="Cat Image" src="https://placekitten.com/40/40" />

      {/* 배지(Badge) 포함 상태 아바타 */}
      <Badge
        overlap="circular"
        anchorOrigin={{ vertical: 'bottom', horizontal: 'right' }}
        badgeContent={
          <Avatar sx={{ width: 16, height: 16, bgcolor: 'green' }}>✓</Avatar>
        }
      >
        <Avatar alt="Online Cat" src="https://placekitten.com/40/40" />
      </Badge>
    </Stack>
  );
}
