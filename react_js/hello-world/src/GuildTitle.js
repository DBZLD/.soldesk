// React 컴포넌트(GuildTitle)를 정의하는 함수형 컴포넌트
function GuildTitle() {
  // JSX 문법으로 HTML과 유사하게 작성된 React 컴포넌트의 UI 구조를 반환
  return (
    // JSX의 최상위 요소로 <div> 태그 사용 (JSX 바깥이므로 일반 주석 사용 가능)
    <div> {/* 여기서부터 JSX 문법 시작 */}
      {/* JSX에서는 HTML 태그와 유사하게 작성하지만, 실제로는 JavaScript 코드 */}
      <h1>Peisia Guild v0.20.0</h1>
      {/* <h1> 태그를 사용해 제목을 출력. */}

      {/* 
        참고로 이건 jsx 의 여러줄 주석임.
      */}
      {/* 한줄 주석도 이걸로 써야 함. */}
    </div>
  );
}

// 이 컴포넌트(GuildTitle)를 다른 파일에서 사용할 수 있도록 내보내기(export) 설정
export default GuildTitle;
