import { createTheme } from '@mui/material/styles';
import '@fontsource/hahmlet';

const theme = createTheme({
  typography: {
    fontFamily: 'Hahmlet, serif',
    fontWeightLight: 600,   // 가는 글씨
    fontWeightRegular: 700, // 기본 글씨
    fontWeightMedium: 800,  // 중간 굵기
  },
});

export default theme;