import { Typography, Box } from '@mui/material';
import RiotAppBar from '../Util/RiotAppBar';
import '../reset.css';
import '../index.css';

function MyPage() {
  return (
    <>
      <Box sx={{ minHeight: '100vh', backgroundColor: 'rgb(41, 41, 41)' }}>
        <RiotAppBar/>
        <Typography variant='h3'>마이 페이지</Typography>
      </Box>
    </>
  );
}

export default MyPage;
