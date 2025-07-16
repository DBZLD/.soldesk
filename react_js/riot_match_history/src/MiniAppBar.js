import React from 'react';
import { AppBar, Toolbar, Typography} from '@mui/material';

function MiniAppBar() {
  return (
    <AppBar position="static">
      <Toolbar>
        <Typography variant="h6" sx={{ flexGrow: 1 }}>
          홈
        </Typography>
      </Toolbar>
    </AppBar>
  );
}

export default MiniAppBar;
