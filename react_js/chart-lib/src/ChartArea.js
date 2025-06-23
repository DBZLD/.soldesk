import {
  AreaChart, Area, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer
} from 'recharts';

const data = [
  { name: '월', 매출: 4000, 지출: 2400 },
  { name: '화', 매출: 3000, 지출: 1398 },
  { name: '수', 매출: 2000, 지출: 9800 },
  { name: '목', 매출: 2780, 지출: 3908 },
  { name: '금', 매출: 1890, 지출: 4800 },
  { name: '토', 매출: 2390, 지출: 3800 },
  { name: '일', 매출: 3490, 지출: 4300 },
];

export default function ChartArea() {
  return (
    // ResponsiveContainer: 부모 크기에 맞춰 반응형 차트
    <ResponsiveContainer width="100%" height={300}>
      
      {/* AreaChart: 면적 차트 (선 + 아래 색상 면적 포함) */}
      <AreaChart data={data}>
        
        {/* CartesianGrid: 배경 격자선 */}
        <CartesianGrid strokeDasharray="3 3" />

        {/* X축: 요일 */}
        <XAxis dataKey="name" />

        {/* Y축: 자동으로 숫자 범위 생성 */}
        <YAxis />

        {/* Tooltip: 마우스 올렸을 때 값 표시 */}
        <Tooltip />

        {/* Legend: 범례 표시 */}
        <Legend 
          verticalAlign="top" 
          align="center"
        />

        {/* Area: 면적 차트 그리는 핵심 컴포넌트 */}
        {/* 주요 속성:
            - type: 선 모양 ("monotone", "linear", 등)
            - dataKey: 데이터 키
            - stroke: 선 색
            - fill: 면 색
            - fillOpacity: 면 색 투명도
        */}
        {/* 매출 면적 */}
        <Area 
          type="monotone" 
          dataKey="매출" 
          stroke="#8884d8" 
          fill="#8884d8" 
          fillOpacity={0.3}
        />

        {/* 지출 면적 */}
        <Area 
          type="monotone" 
          dataKey="지출" 
          stroke="#82ca9d" 
          fill="#82ca9d" 
          fillOpacity={0.3}
        />
      </AreaChart>
    </ResponsiveContainer>
  );
}
