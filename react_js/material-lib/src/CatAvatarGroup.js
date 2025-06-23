import React from 'react';
import Avatar from '@mui/material/Avatar';
import AvatarGroup from '@mui/material/AvatarGroup';
import Stack from '@mui/material/Stack';

export default function CatAvatarGroup() {
  return (
    <Stack spacing={2} alignItems="center">
      {/* 기본 아바타 그룹: 최대 4명 보이게, 나머지는 +n으로 표시 */}
      <AvatarGroup max={4}>
        <Avatar alt="Alice" src="https://placekitten.com/40/40" />
        <Avatar alt="Bob" src="https://placekitten.com/41/41" />
        <Avatar alt="Charlie" src="https://placekitten.com/42/42" />
        <Avatar alt="Dave" src="https://placekitten.com/43/43" />
        <Avatar alt="Eve" src="https://placekitten.com/44/44" />
      </AvatarGroup>

      {/* 커스텀 최대 수 & 사이즈 조절 */}
      <AvatarGroup max={3}>
        <Avatar sx={{ width: 48, height: 48 }}>A</Avatar>
        <Avatar sx={{ width: 48, height: 48 }}>B</Avatar>
        <Avatar sx={{ width: 48, height: 48 }}>C</Avatar>
        <Avatar sx={{ width: 48, height: 48 }}>D</Avatar>
      </AvatarGroup>
    </Stack>
  );
}
