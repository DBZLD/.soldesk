import {
    LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer
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

export default function ChartLine() {
    return (
        // recharts에서 차트를 반응형(Responsive) 으로 만들기 위해 사용하는 래퍼 컴포넌트
        // width="100%": 부모 요소 가로 길이만큼 차트 너비 설정
        // height={300}: 고정 높이 (px)
        // ResponsiveContainer: 차트를 반응형으로 만들어주는 래퍼 컴포넌트
        <ResponsiveContainer width="100%" height={300}>

            {/* LineChart: 선 그래프를 그리는 메인 차트 컴포넌트 */}
            <LineChart data={data}>

                {/* XAxis: 가로축 설정, dataKey는 각 데이터 항목의 x축 라벨 필드를 지정 */}
                <XAxis dataKey="name" />

                {/* YAxis: 세로축 자동 생성 */}
                    {/* dataKey	이 축이 참조할 데이터 필드 지정 (보통 생략해도 됨)
                    type	number(기본), category 등 설정 가능
                    domain	축의 범위 지정, 예: [0, 'dataMax + 100']
                    tick	false로 하면 눈금 안 보이게 할 수 있음
                    tickFormatter	눈금에 단위 붙이기 등 포맷 지정
                    label	축 제목 넣기 가능
                    width	Y축 영역의 너비 지정
                    orientation	"left" 또는 "right" 가능
                    allowDecimals	소수점 허용 여부 (true/false)                 */}
                <YAxis />

                {/* Tooltip: 마우스를 차트에 올렸을 때 데이터 정보 툴팁 표시 */}
                <Tooltip />
                {/* <Tooltip 
                    formatter={(value) => `${value}원`} 
                    labelFormatter={(label) => `${label}요일`} 
                    separator=" → " /> */}
                    {/* cursor	툴팁 마우스 오버 시 배경 하이라이트 설정 (false 하면 비활성)
                    formatter	데이터 값 포맷 바꾸기 ((value, name) => ...)
                    labelFormatter	X축 라벨 포맷 바꾸기 ((label) => ...)
                    content	툴팁 커스텀 컴포넌트로 완전 제어
                    separator	데이터 이름과 값 사이 구분자 (기본은 : )
                    itemStyle	항목 스타일 지정 (color, fontSize 등)
                    labelStyle	라벨 텍스트 스타일
                    wrapperStyle	전체 툴팁 박스 스타일 */}

                {/* Legend: 선 색상과 이름을 표시하는 범례 추가 */}
                {/* <Legend /> */}
                <Legend layout="horizontal" verticalAlign="bottom" align="left" />

                    {/* layout	방향: "horizontal"(기본), "vertical"
                    verticalAlign	"top", "middle", "bottom" 중 하나
                    align	"left", "center", "right" (수평 정렬)
                    iconType	"line", "circle", "rect", "cross" 등 (범례 아이콘 모양)
                    wrapperStyle	스타일 객체 (예: 마진, 폰트 사이즈 등 조절용)
                    formatter	각 항목 텍스트를 포맷팅하는 함수
                    payload	수동으로 항목 설정 (차트에 안 나와도 범례 만들 수 있음)
                    content	완전 커스텀 컴포넌트 지정 */}

                {/* Line: 실제 선 그래프 그리는 컴포넌트
                    - type="monotone": 곡선을 부드럽게 그리는 옵션
                    - dataKey="매출": 데이터에서 y축 값으로 쓸 필드
                    - stroke="#8884d8": 선 색상 설정
                */}

                {/* 매출 라인 */}
                <Line type="monotone" dataKey="매출" stroke="#8884d8" />
                {/* 지출 라인 */}
                <Line type="monotone" dataKey="지출" stroke="#82ca9d" />                
            </LineChart>
        </ResponsiveContainer>

    );
}
