import {
  BarChart, Bar, XAxis, YAxis, Tooltip, Legend, ResponsiveContainer
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

export default function ChartBar() {
  return (
    // ResponsiveContainer: 부모 요소 크기에 따라 차트 크기 자동 조절
    <ResponsiveContainer width="100%" height={300}>

      {/* BarChart: 막대형 차트 생성, data 속성으로 시각화할 데이터 배열 전달 */}
      <BarChart data={data}>

        {/* XAxis: 가로축 설정, dataKey는 라벨 필드 지정 */}
        <XAxis dataKey="name" />

        {/* YAxis: 세로축 설정 */}
        {/* 주요 속성 예시:
            - type: "number" | "category" (기본은 number)
            - domain: [0, 'dataMax + 100']
            - tickFormatter: (value) => `${value}원`
            - allowDecimals: false (소수점 제거)
        */}
        <YAxis />

        {/* Tooltip: 마우스 오버 시 데이터 툴팁 표시 */}
        {/* 주요 속성 예시:
            - formatter: (value) => `${value}원`
            - labelFormatter: (label) => `${label}요일`
            - cursor: false (배경 강조 비활성화)
        */}
        <Tooltip />

        {/* Legend: 범례 표시 */}
        {/* 주요 속성 예시:
            - layout: "horizontal" | "vertical"
            - align: "left" | "center" | "right"
            - verticalAlign: "top" | "middle" | "bottom"
            - iconType: "line" | "circle" | "rect"
            - formatter: (value) => `매출: ${value}`
        */}
        <Legend 
          layout="horizontal"
          verticalAlign="bottom"
          align="center"
        />

        {/* Bar: 막대 그래프 그리기 */}
        {/* 주요 속성:
            - dataKey: 값 필드 지정
            - fill: 색상
            - barSize: 막대 두께
            - stackId: 누적형 막대 만들 때 사용
            - label: { position: "top" } 로 수치 표시 가능
        */}

        {/* 매출 막대 */}
        <Bar dataKey="매출" fill="#8884d8" />

        {/* 지출 막대 */}
        <Bar dataKey="지출" fill="#82ca9d" />
      </BarChart>
    </ResponsiveContainer>
  );
}
