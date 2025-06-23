import React, { useState } from 'react';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';

export default function CatTab() {
  // 현재 선택된 탭 index를 상태로 관리
  const [value, setValue] = useState(0);

  // 탭 클릭 시 실행되는 함수
  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <Box sx={{ width: '100%', typography: 'body1' }}>
      {/* Tabs: 탭 목록 컨테이너 */}
      {/* value: 현재 선택된 탭 인덱스 / onChange: 선택 변경 핸들러 */}
      <Tabs value={value} onChange={handleChange} centered>
        <Tab label="고양이 소개" />
        <Tab label="고양이 능력치" />
        <Tab label="고양이 스토리" />
      </Tabs>

      {/* 선택된 탭에 따라 콘텐츠 표시 */}
      {value === 0 && (
        <Box sx={{ p: 2 }}>
          <Typography>이 고양이는 세상에서 가장 귀엽습니다.</Typography>
        </Box>
      )}
      {value === 1 && (
        <Box sx={{ p: 2 }}>
          <Typography>민첩성: 90 / 잠재력: SSR / 점프력: 100</Typography>
        </Box>
      )}
      {value === 2 && (
        <Box sx={{ p: 2 }}>
          <Typography>고양이는 옛날 옛적 마법왕국에서 태어났습니다...</Typography>
        </Box>
      )}
    </Box>
  );
}
