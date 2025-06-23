import React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';

export default function CatCard() {
  return (
    // Card: 정보를 묶어서 보여주는 박스형 UI
    // variant="outlined": 외곽선 있는 스타일 (기본은 그림자 있음)
    <Card variant="outlined" sx={{ maxWidth: 300, margin: 2 }}>
      
      {/* CardContent: 텍스트/이미지 등 본문 내용 */}
      <CardContent>
        {/* Typography: 텍스트 요소 (variant로 크기 설정 가능) */}
        <Typography variant="h5" component="div">
          고양이 카드
        </Typography>
        <Typography sx={{ mb: 1.5 }} color="text.secondary">
          귀여움 레벨: SSR
        </Typography>
        <Typography variant="body2">
          이 고양이는 매우 귀엽고 능력이 뛰어나며, 항상 자는 걸 좋아합니다.
        </Typography>
      </CardContent>

      {/* CardActions: 하단 버튼 등 액션 영역 */}
      <CardActions>
        <Button size="small">더 보기</Button>
        <Button size="small">공유</Button>
      </CardActions>
    </Card>
  );
}
