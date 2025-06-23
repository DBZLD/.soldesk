import {
  PieChart, Pie, Cell, Tooltip, Legend, ResponsiveContainer
} from 'recharts';

const data = [
  { name: 'A제품', value: 400 },
  { name: 'B제품', value: 300 },
  { name: 'C제품', value: 300 },
  { name: 'D제품', value: 200 },
];

// 각 파이 조각에 색상 지정
const COLORS = ['#0088FE', '#00C49F', '#FFBB28', '#FF8042'];

export default function ChartPie() {
  return (
    // ResponsiveContainer: 반응형 컨테이너
    <ResponsiveContainer width="100%" height={300}>
      
      {/* PieChart: 원형 차트 */}
      <PieChart>
        
        {/* Pie: 실제 원형 영역 그리는 컴포넌트 */}
        {/* 주요 속성:
            - data: 데이터 배열
            - dataKey: 값 필드
            - nameKey: 라벨 필드
            - cx, cy: 중심 위치 (% 또는 숫자)
            - outerRadius: 반지름
            - fill: 기본 색상
            - label: 각 조각에 라벨 표시 여부
        */}
        <Pie
          data={data}
          dataKey="value"
          nameKey="name"
          cx="50%"
          cy="50%"
          outerRadius={100}
          fill="#8884d8"
          label
        >
          {/* 각 조각에 색상 매핑 */}
          {data.map((entry, index) => (
            <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />
          ))}
        </Pie>

        {/* Tooltip: 마우스 오버 시 정보 표시 */}
        <Tooltip />

        {/* Legend: 범례 (자동으로 name 표시) */}
        <Legend
          layout="horizontal"
          verticalAlign="bottom"
          align="center"
        />
      </PieChart>
    </ResponsiveContainer>
  );
}
