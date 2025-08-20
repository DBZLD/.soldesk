import React from 'react';
import { AppBar, Toolbar, Typography } from '@mui/material';

function MiniAppBar() {
  return (
    <AppBar position="static" sx={{ backgroundColor: 'rgba(54, 45, 104, 1)' }}>
      <Toolbar sx={{ height: '40px', minHeight: '40px !important', flexGrow: 10 }}>
        <Typography variant="subtitle2">
          홈
        </Typography>
      </Toolbar>
    </AppBar>
  );
}

export default MiniAppBar;
