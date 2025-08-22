import { createTheme } from '@mui/material/styles';
import '@fontsource/hahmlet';

const theme = createTheme({
  typography: {
    fontFamily: 'Hahmlet, serif',
    fontWeightLight: 600,   
    fontWeightRegular: 700,
    fontWeightMedium: 800,  
    allVariants: {
      color: 'rgba(200, 200, 200, 1)',  
    },
  },
  components: {
    MuiOutlinedInput: {
      styleOverrides: {
        root: {
          color: "rgb(200, 200, 200)",
          "& fieldset": { borderColor: "rgba(54, 45, 104, 1)", borderWidth: 3 },
          "&:hover fieldset": { borderColor: "rgba(54, 45, 104, 1)" },
          "&.Mui-focused fieldset": { borderColor: "rgba(24, 14, 78, 1)" },
        },
      },
    },
    MuiInputLabel: {
      styleOverrides: {
        root: {
          color: "rgba(170,170,170,0.7)",
          top: "50%",
          transform: "translate(14px, -50%) scale(1)",
          "&.MuiInputLabel-shrink": {
            color: "rgba(200, 200, 200, 1)",
            top: 0,
            transform: "translate(14px, -9px) scale(0.75)",
          },
        },
      },
    },
  },
});

export default theme;