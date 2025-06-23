import React from 'react';
import Breadcrumbs from '@mui/material/Breadcrumbs';
import Link from '@mui/material/Link';
import Typography from '@mui/material/Typography';

export default function CatBreadcrumbs() {
  // 클릭 시 호출되는 예시 함수 (페이지 이동 등)
  const handleClick = (event) => {
    event.preventDefault();
    alert(`이동: ${event.target.textContent}`);
  };

  return (
    // Breadcrumbs: 경로 표시용 컨테이너
    <Breadcrumbs aria-label="breadcrumb">
      {/* Link 컴포넌트로 클릭 가능한 상위 경로 표시 */}
      <Link underline="hover" color="inherit" href="/" onClick={handleClick}>
        홈
      </Link>
      <Link underline="hover" color="inherit" href="/cats" onClick={handleClick}>
        고양이
      </Link>
      {/* 마지막은 현재 위치, Link 대신 Typography 사용 */}
      <Typography color="text.primary">상세보기</Typography>
    </Breadcrumbs>
  );
}
