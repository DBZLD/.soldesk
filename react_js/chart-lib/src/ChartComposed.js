import {
  ComposedChart, Line, Bar, Area, XAxis, YAxis, Tooltip, Legend, CartesianGrid, ResponsiveContainer
} from 'recharts';

const data = [
  { name: '월', 매출: 4000, 지출: 2400, 이익: 1600 },
  { name: '화', 매출: 3000, 지출: 1398, 이익: 1602 },
  { name: '수', 매출: 2000, 지출: 9800, 이익: -7800 },
  { name: '목', 매출: 2780, 지출: 3908, 이익: -1128 },
  { name: '금', 매출: 1890, 지출: 4800, 이익: -2910 },
  { name: '토', 매출: 2390, 지출: 3800, 이익: -1410 },
  { name: '일', 매출: 3490, 지출: 4300, 이익: -810 },
];

export default function ChartComposed() {
  return (
    // ResponsiveContainer: 반응형 차트 크기 자동 조절
    <ResponsiveContainer width="100%" height={350}>
      
      {/* ComposedChart: 여러 그래프 타입 조합 가능 */}
      <ComposedChart data={data}>
        
        {/* 배경 격자선 */}
        <CartesianGrid stroke="#f5f5f5" />

        {/* X축: 요일 이름 */}
        <XAxis dataKey="name" />

        {/* Y축: 숫자 자동 계산 */}
        <YAxis />

        {/* 마우스 오버 툴팁 */}
        <Tooltip />

        {/* 범례 */}
        <Legend />

        {/* Area: 지출 면적 차트 */}
        <Area 
          type="monotone" 
          dataKey="지출" 
          fill="#ffc658" 
          stroke="#ffc658" 
          fillOpacity={0.4}
        />

        {/* Bar: 매출 막대 차트 */}
        <Bar 
          dataKey="매출" 
          barSize={20} 
          fill="#8884d8" 
        />

        {/* Line: 이익 선 그래프 */}
        <Line 
          type="monotone" 
          dataKey="이익" 
          stroke="#ff7300" 
        />
      </ComposedChart>
    </ResponsiveContainer>
  );
}
