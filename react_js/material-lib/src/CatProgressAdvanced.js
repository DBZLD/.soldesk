import React, { useState, useEffect } from 'react';
import Box from '@mui/material/Box';
import LinearProgress from '@mui/material/LinearProgress';
import Typography from '@mui/material/Typography';
import Stack from '@mui/material/Stack';

export default function CatProgressAdvanced() {
  // 작업별 진행률 상태
  const [tasks, setTasks] = useState([
    { name: '다운로드', progress: 20 },
    { name: '업로드', progress: 45 },
    { name: '처리', progress: 60 },
  ]);

  // 진행률 자동 증가 시뮬레이션
  useEffect(() => {
    const timer = setInterval(() => {
      setTasks(prev =>
        prev.map(task => ({
          ...task,
          progress: Math.min(task.progress + Math.random() * 15, 100),
        }))
      );
    }, 1000);
    return () => clearInterval(timer);
  }, []);

  return (
    <Stack spacing={3} sx={{ p: 2 }}>
      {tasks.map((task, i) => (
        // 각 작업별 진행 바 영역
        <Box key={i}>
          <Box display="flex" justifyContent="space-between">
            {/* 작업 이름 + 퍼센트 */}
            <Typography variant="body1">{task.name}</Typography>
            <Typography variant="body2">{`${Math.round(task.progress)}%`}</Typography>
          </Box>
          {/* LinearProgress: 진행 상태 표시 바 */}
          <LinearProgress variant="determinate" value={task.progress} />
        </Box>
      ))}
    </Stack>
  );
}
