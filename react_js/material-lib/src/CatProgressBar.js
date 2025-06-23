import React, { useState, useEffect } from 'react';
import Box from '@mui/material/Box';
import LinearProgress from '@mui/material/LinearProgress';
import CircularProgress from '@mui/material/CircularProgress';
import Typography from '@mui/material/Typography';

export default function CatProgressBar() {
  const [progress, setProgress] = useState(0);

  // 진행률 애니메이션 예시: 0 → 100 → 초기화 루프
  useEffect(() => {
    const timer = setInterval(() => {
      setProgress((prev) => (prev >= 100 ? 0 : prev + 10));
    }, 500);
    return () => clearInterval(timer);
  }, []);

  return (
    <Box sx={{ width: '100%', p: 2 }}>
      {/* LinearProgress: 직선형 진행 바 */}
      <Typography>Linear Progress</Typography>
      <LinearProgress variant="determinate" value={progress} />

      <Box sx={{ my: 2 }} />

      {/* CircularProgress: 원형 진행 인디케이터 */}
      <Typography>Circular Progress</Typography>
      <Box sx={{ position: 'relative', display: 'inline-flex' }}>
        <CircularProgress variant="determinate" value={progress} size={60} />
        <Box
          sx={{
            top: 0,
            left: 0,
            bottom: 0,
            right: 0,
            position: 'absolute',
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
          }}
        >
          <Typography variant="caption" component="div" color="text.secondary">
            {`${progress}%`}
          </Typography>
        </Box>
      </Box>

      <Box sx={{ my: 2 }} />

      {/* indeterminate: 진행률 모르는 경우 사용 (Loader 느낌) */}
      <Typography>Indeterminate Loader</Typography>
      <LinearProgress />
    </Box>
  );
}
