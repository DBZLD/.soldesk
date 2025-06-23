import React from 'react';
import Grid from '@mui/material/Grid';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';

export default function CatGrid() {
  // 샘플 카드 데이터
  const cats = [
    { id: 1, name: '냥이 A', desc: '매우 귀여움' },
    { id: 2, name: '냥이 B', desc: '조금 도도함' },
    { id: 3, name: '냥이 C', desc: '졸림주의' },
    { id: 4, name: '냥이 D', desc: '활동적' },
  ];

  return (
    <Grid container spacing={2}>
      {/* Grid: 그리드 전체 컨테이너 (spacing: 칸 사이 여백) */}

      {cats.map((cat) => (
        // Grid item: 각 칸 (xs=12: 모바일 전체, md=6: 데스크탑 절반, lg=3: 4분할)
        <Grid item xs={12} sm={6} md={4} lg={3} key={cat.id}>
          <Card variant="outlined">
            <CardContent>
              <Typography variant="h6">{cat.name}</Typography>
              <Typography variant="body2">{cat.desc}</Typography>
            </CardContent>
          </Card>
        </Grid>
      ))}
    </Grid>
  );
}
