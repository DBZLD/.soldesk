import React from 'react';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import Skeleton from '@mui/material/Skeleton';
import Stack from '@mui/material/Stack';
import Avatar from '@mui/material/Avatar';

// export default function CatSkeletonList({ loading = false, count = 5 }) { //loading true/false 바꿔보면 다르게 나옴
export default function CatSkeletonList({ loading = true, count = 5 }) {
  return (
    <List>
      {[...Array(count)].map((_, idx) => (
        <ListItem key={idx} divider>
          {loading ? (
            // 로딩 중일 때 스켈레톤 표시
            <Stack direction="row" spacing={2} alignItems="center" width="100%">
              {/* 프로필 썸네일 */}
              <Skeleton variant="circular" width={40} height={40} />

              {/* 텍스트 라인 2줄 */}
              <Stack spacing={1} flexGrow={1}>
                <Skeleton variant="text" width="80%" height={20} />
                <Skeleton variant="text" width="50%" height={16} />
              </Stack>
            </Stack>
          ) : (
            // 실제 내용이 들어올 자리
            <Stack direction="row" spacing={2} alignItems="center">
              <Avatar />
              <div>
                <div>고양이 이름</div>
                <div style={{ fontSize: '0.8rem', color: '#888' }}>소개글</div>
              </div>
            </Stack>
          )}
        </ListItem>
      ))}
    </List>
  );
}
