import ReactDOM from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';
import { ThemeProvider } from '@mui/material/styles';
import theme from './theme';
import Locate from './Locate';
import './index.css';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <ThemeProvider theme={theme}>
    <BrowserRouter>
      <Locate />
    </BrowserRouter>
  </ThemeProvider>
);
