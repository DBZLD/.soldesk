import { ImageList, ImageListItem } from '@mui/material';
import './reset.css';
import './index.css';

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
    <div className='mainPage'>
      <div className='mainTitle'>라이엇 전적 검색</div>
      <ImageList cols={4} rowHeight={250}>
        {itemData.map((item) => (
          <ImageListItem key={item.img}>
            <a className='mainSubtitle' href={item.nav}>
              <img className='mainImg'
                src={`${item.img}?w=164&h=164&fit=crop&auto=format`}
                alt={item.title}
                loading="lazy"
              />
              <div>{item.title}</div>
            </a>
          </ImageListItem>
        ))}
      </ImageList>
    </div>
  );
}

export default MainPage;