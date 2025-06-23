import React, { useState } from 'react';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import Button from '@mui/material/Button';
import Drawer from '@mui/material/Drawer';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';
import Divider from '@mui/material/Divider';

export default function CatAppBarPlus() {
  // Drawer 열림 여부를 상태로 관리
  const [open, setOpen] = useState(false);

  // Drawer 열기
  const handleDrawerOpen = () => {
    setOpen(true);
  };

  // Drawer 닫기
  const handleDrawerClose = () => {
    setOpen(false);
  };

  return (
    <>
      {/* AppBar: 상단 고정 네비게이션 바 */}
      <AppBar position="static" color="primary">
        <Toolbar>

          {/* IconButton: 햄버거 버튼 */}
          <IconButton edge="start" color="inherit" aria-label="menu" onClick={handleDrawerOpen} sx={{ mr: 2 }}>
            <MenuIcon />
          </IconButton>

          {/* 앱 제목 */}
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            CatAppPlus
          </Typography>

          {/* 로그인 버튼 */}
          <Button color="inherit">로그인</Button>
        </Toolbar>
      </AppBar>

      {/* Drawer: 왼쪽에서 나오는 메뉴 패널 */}
      <Drawer anchor="left" open={open} onClose={handleDrawerClose}>
        <List sx={{ width: 200 }}>
          <ListItem button onClick={handleDrawerClose}>
            <ListItemText primary="홈" />
          </ListItem>
          <ListItem button onClick={handleDrawerClose}>
            <ListItemText primary="소개" />
          </ListItem>
          <ListItem button onClick={handleDrawerClose}>
            <ListItemText primary="설정" />
          </ListItem>
          <Divider />
          <ListItem button onClick={handleDrawerClose}>
            <ListItemText primary="로그아웃" />
          </ListItem>
        </List>
      </Drawer>
    </>
  );
}
