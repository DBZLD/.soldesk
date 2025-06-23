import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import Button from '@mui/material/Button';

export default function CatAppBar() {
  return (
    // AppBar: 상단 고정 바
    // 주요 속성:
    // - position: 위치 지정 ("static", "fixed", "absolute", "sticky")
    // - color: 색상 지정 ("primary", "secondary", "default", "transparent")
    <AppBar position="static" color="primary">

      {/* Toolbar: AppBar 안에서 요소 정렬해주는 컨테이너 */}
      <Toolbar>

        {/* IconButton: 아이콘 눌리는 버튼 */}
        {/* edge="start": 왼쪽 정렬 / color="inherit": 상위 AppBar 색상 상속 */}
        <IconButton edge="start" color="inherit" aria-label="menu" sx={{ mr: 2 }}>
          {/* MenuIcon: 햄버거 아이콘 */}
          <MenuIcon />
        </IconButton>

        {/* Typography: 텍스트 출력용 컴포넌트 */}
        {/* variant: 글씨 크기/스타일 지정 / sx: 간단한 스타일 객체 */}
        <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
          CatApp
        </Typography>

        {/* Button: 로그인 등 액션 버튼 */}
        {/* color="inherit": AppBar 배경색 기준 반전 */}
        <Button color="inherit">로그인</Button>
      </Toolbar>
    </AppBar>
  );
}
