import {
  ScatterChart, Scatter, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer
} from 'recharts';

const data = [
  { x: 100, y: 200 },
  { x: 120, y: 100 },
  { x: 170, y: 300 },
  { x: 140, y: 250 },
  { x: 150, y: 400 },
];

export default function ChartScatter() {
  return (
    // ResponsiveContainer: 반응형 처리
    <ResponsiveContainer width="100%" height={350}>

      {/* ScatterChart: X, Y 좌표 기반 산점도 */}
      <ScatterChart>
        
        {/* 격자선 */}
        <CartesianGrid />

        {/* X축: x 값 기준 */}
        <XAxis 
          type="number" 
          dataKey="x" 
          name="나이" 
          unit="세"
        />

        {/* Y축: y 값 기준 */}
        <YAxis 
          type="number" 
          dataKey="y" 
          name="수입" 
          unit="만원"
        />

        {/* 툴팁 */}
        <Tooltip cursor={{ strokeDasharray: '3 3' }} />

        {/* 범례 */}
        <Legend />

        {/* Scatter: 점 데이터 시각화 */}
        {/* 주요 속성:
            - name: 범례 표시 이름
            - data: 점 좌표 배열
            - fill: 점 색상
        */}
        <Scatter 
          name="회원 샘플" 
          data={data} 
          fill="#8884d8" 
        />
      </ScatterChart>
    </ResponsiveContainer>
  );
}
