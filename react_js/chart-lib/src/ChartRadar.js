import {
  RadarChart, Radar, PolarGrid, PolarAngleAxis, PolarRadiusAxis, Tooltip, Legend, ResponsiveContainer
} from 'recharts';

const data = [
  { 항목: '기획', A: 120, B: 110 },
  { 항목: '디자인', A: 98, B: 130 },
  { 항목: '프론트엔드', A: 86, B: 130 },
  { 항목: '백엔드', A: 99, B: 100 },
  { 항목: '배포', A: 85, B: 90 },
  { 항목: '협업', A: 65, B: 85 },
];

export default function ChartRadar() {
  return (
    // ResponsiveContainer: 반응형 처리
    <ResponsiveContainer width="100%" height={350}>
      
      {/* RadarChart: 중심에서 퍼지는 방사형 차트 */}
      <RadarChart data={data}>
        
        {/* PolarGrid: 배경 방사선과 원형 격자 */}
        <PolarGrid />

        {/* PolarAngleAxis: 항목명 위치 (가로축 역할) */}
        <PolarAngleAxis dataKey="항목" />

        {/* PolarRadiusAxis: 수치 값 범위 (세로축 역할) */}
        <PolarRadiusAxis />

        {/* Tooltip: 마우스 올렸을 때 값 표시 */}
        <Tooltip />

        {/* Legend: A, B 시리즈 구분 */}
        <Legend />

        {/* Radar: 실제 레이더 영역 그리는 부분 */}
        {/* 주요 속성:
            - name: 범례 표시용 이름
            - dataKey: 데이터 키 (A 또는 B)
            - stroke: 선 색상
            - fill: 면 색상
            - fillOpacity: 투명도
        */}
        <Radar 
          name="A팀" 
          dataKey="A" 
          stroke="#8884d8" 
          fill="#8884d8" 
          fillOpacity={0.6} 
        />
        <Radar 
          name="B팀" 
          dataKey="B" 
          stroke="#82ca9d" 
          fill="#82ca9d" 
          fillOpacity={0.6} 
        />
      </RadarChart>
    </ResponsiveContainer>
  );
}
