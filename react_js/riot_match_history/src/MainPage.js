import React from 'react';
import { Box, Typography, ImageList, ImageListItem, Link } from '@mui/material';

function MainPage() {
  const itemData = [
    {
      img: 'https://cdn.apnews.kr/news/photo/202005/20200527_1_bodyimg_856029.PNG',
      title: '리그 오브 레전드',
      nav: '/LOLMain',
    },
    {
      img: 'https://www.riotgames.com/darkroom/2880/fab68f870f6da8998086165e608ea621:4daaca1e4523ad006c3f73be050aebb2/tft.jpg',
      title: '전략적 팀 전투',
      nav: '/TFTMain',
    },
    {
      img: 'https://cdn.m-i.kr/news/photo/202209/951041_714391_5730.jpg',
      title: '발로란트',
      nav: '/VALMain',
    },
    {
      img: 'https://yozm.wishket.com/media/news/1459/image001.png',
      title: '커뮤니티',
      nav: '/COMMain',
    },
  ];

  return (
    <Box sx={{ width: '100%', minHeight: '100vh', backgroundColor: 'rgb(41, 41, 41)', color: 'rgb(170, 170, 170)', textAlign: 'center', }}>
      {/* 타이틀 */}
      <Typography variant="h2" sx={{ fontSize: 70, fontWeight: 800, pt: 5, pb: 5 }}>
        라이엇 전적 검색
      </Typography>

      {/* 메뉴 리스트 */}
      <ImageList cols={4} rowHeight={250} sx={{ justifyItems: 'center' }}>
        {/*itemData를 돌면서 전체 출력 */}
        {itemData.map((item) => (
          <ImageListItem key={item.img}>
            <Link href={item.nav} underline="none"
              sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', fontSize: 40, color: 'inherit', }}
            >
              <Box component="img" src={`${item.img}?w=300&h=170&fit=crop&auto=format`} alt={item.title} loading="lazy" // 카테고리 이미지 
                sx={{ width: 300, height: 170, borderRadius: 2, mb: 1, }}
              />
              <Typography variant="h4" sx={{ fontSize: 40, fontWeight: 700 }}>
                {item.title} {/* 카테고리 이름 */}
              </Typography>
            </Link>
          </ImageListItem>
        ))}
      </ImageList>
    </Box>
  );
}

export default MainPage;
