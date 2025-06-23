import React from 'react';  // React 라이브러리를 가져옴 (JSX 문법을 사용하기 위해 필요함)
import ReactDOM from 'react-dom/client';  // ReactDOM은 React 컴포넌트를 실제 DOM에 렌더링할 때 사용됨
import './index.css'; // CSS 파일을 불러옴 (전역 스타일을 적용)


import App from './App.js';  // <-- 여기서는 명시적으로 .js 확장자를 추가함

const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
