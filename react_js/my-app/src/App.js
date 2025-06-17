import React, { useState } from 'react';
import './App.css';

// 공통 버튼 컴포넌트
function CounterButton({ onClick, label }) {
  return <button onClick={onClick}>{label}</button>;
}

function Cat() {
  const [a, setA] = useState(0);
  const [b, setB] = useState(0);
  const [c, setC] = useState(0);

  return (
    <>
      <h1>간식a {a}</h1>
      <CounterButton onClick={() => setA(a + 1)} label="+" />
      <CounterButton onClick={() => setA(a - 1)} label="-" />
      <h1>간식b {b}</h1>
      <CounterButton onClick={() => setB(b + 1)} label="+" />
      <CounterButton onClick={() => setB(b - 1)} label="-" />
      <h1>간식c {c}</h1>
      <CounterButton onClick={() => setC(c + 1)} label="+" />
      <CounterButton onClick={() => setC(c - 1)} label="-" />
    </>
  );
}

function App() {
  return <Cat />;
}

export default App;
