import React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import Skeleton from '@mui/material/Skeleton';
import Stack from '@mui/material/Stack';

// export default function CatSkeleton({ loading = false }) { // 로딩 후 화면이 나옴. 이 주석 풀면
export default function CatSkeleton({ loading = true }) {
  return (
    <Card variant="outlined" sx={{ maxWidth: 300, margin: 2 }}>
      <CardContent>
        <Stack spacing={1}>

          {/* 제목 영역 스켈레톤 (기본 : width 80%, height 40px) */}
          {loading ? (
            <Skeleton variant="text" width="80%" height={40} />
          ) : (
            <Typography variant="h5">고양이 이름</Typography>
          )}

          {/* 부제목 스켈레톤 (width 60%) */}
          {loading ? (
            <Skeleton variant="text" width="60%" height={20} />
          ) : (
            <Typography color="text.secondary">등급 SSR</Typography>
          )}

          {/* 본문 영역 스켈레톤 (여러 줄 텍스트 형태) */}
          {loading ? (
            <>
              <Skeleton variant="text" />
              <Skeleton variant="text" />
              <Skeleton variant="text" width="90%" />
            </>
          ) : (
            <Typography variant="body2">
              이 고양이는 매우 귀엽고 조용한 성격을 가졌습니다.
            </Typography>
          )}

        </Stack>
      </CardContent>
    </Card>
  );
}
