import ReactDOM from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';
import { ThemeProvider } from '@mui/material/styles';
import theme from './Util/theme';
import Locate from './Util/Locate';
import './index.css';
import { UserProvider } from './Util/UserContext';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <ThemeProvider theme={theme}> {/* 테이블, 검색창, 폰트 테마 적용 */}
    <BrowserRouter> 
      <UserProvider>
        <Locate /> {/* 네비게이션(페이지 이동) */}
      </UserProvider>
    </BrowserRouter>
  </ThemeProvider>
);
