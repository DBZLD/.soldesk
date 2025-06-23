import React, { useState } from 'react';
import BottomNavigation from '@mui/material/BottomNavigation';
import BottomNavigationAction from '@mui/material/BottomNavigationAction';
import RestoreIcon from '@mui/icons-material/Restore';
import FavoriteIcon from '@mui/icons-material/Favorite';
import LocationOnIcon from '@mui/icons-material/LocationOn';
import Paper from '@mui/material/Paper';

export default function CatBottomNav() {
  const [value, setValue] = useState(0);

  return (
    // Paper: 배경 스타일 감싸기 (elevation=3이면 약간 그림자 효과)
    <Paper
      sx={{ position: 'fixed', bottom: 0, left: 0, right: 0 }}
      elevation={3}
    >
      {/* BottomNavigation: 하단 메뉴 바 */}
      <BottomNavigation
        showLabels // 텍스트 라벨 보이기
        value={value}
        onChange={(event, newValue) => {
          setValue(newValue);
        }}
      >
        {/* BottomNavigationAction: 각 탭 버튼 */}
        <BottomNavigationAction label="최근기록" icon={<RestoreIcon />} />
        <BottomNavigationAction label="즐겨찾기" icon={<FavoriteIcon />} />
        <BottomNavigationAction label="위치" icon={<LocationOnIcon />} />
      </BottomNavigation>
    </Paper>
  );
}
