import {
  RadialBarChart, RadialBar, Legend, Tooltip, ResponsiveContainer
} from 'recharts';

const data = [
  { name: 'JavaScript', 퍼센트: 86, fill: '#8884d8' },
  { name: 'Python', 퍼센트: 65, fill: '#83a6ed' },
  { name: 'Java', 퍼센트: 45, fill: '#8dd1e1' },
  { name: 'C++', 퍼센트: 30, fill: '#82ca9d' },
  { name: 'Go', 퍼센트: 20, fill: '#a4de6c' },
];

export default function ChartRadialBar() {
  return (
    // ResponsiveContainer: 반응형 컨테이너
    <ResponsiveContainer width="100%" height={350}>

      {/* RadialBarChart: 원형 막대형 차트 */}
      {/* 주요 속성:
          - cx, cy: 중심 좌표 (기본은 "50%")
          - innerRadius, outerRadius: 원 안쪽/바깥쪽 반지름
          - barSize: 막대 두께
          - startAngle, endAngle: 시계 방향 회전 각도
      */}
      <RadialBarChart 
        cx="50%" cy="50%" 
        innerRadius="20%" 
        outerRadius="90%" 
        barSize={15} 
        data={data}
        startAngle={180}
        endAngle={0}
      >
        {/* RadialBar: 실제 막대 영역 */}
        {/* 주요 속성:
            - minAngle: 최소 각도 (값이 작아도 보이게)
            - background: 회색 배경 막대
            - label: { position: "insideStart" } 등으로 텍스트 표시
            - clockWise: 시계 방향 여부
        */}
        <RadialBar
          label={{ position: 'insideStart', fill: '#fff' }}
          background
          clockWise
          dataKey="퍼센트"
        />

        {/* Tooltip: 마우스 오버 시 값 표시 */}
        <Tooltip />

        {/* Legend: 이름 표시 */}
        <Legend 
          iconSize={10}
          layout="vertical"
          verticalAlign="middle"
          align="right"
        />
      </RadialBarChart>
    </ResponsiveContainer>
  );
}
