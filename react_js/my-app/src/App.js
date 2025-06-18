import React, { useState } from 'react';
import './App.css';

var jobs = ["전사","마법사","궁수","도적","사제"];
var grade = ["SSR","SR","S","R","H","N"];

function dice(s,e){
  return Math.floor(Math.random()*(e-s+1))+s;
}

function Card({ job, grade }) {
  return (
    <div className={`card ${job} ${grade}`}>
      {job} - {grade} {/* job과 grade를 표시 */}
    </div>
  );
}

function CardArea({ children }) {
  return (
    <div id='card_area'>
      {children}
    </div>
  );
}

function App() {
  function gacha(){
    var j = jobs[dice(0,4)];
    var g = grade[dice(0,5)];
    console.log(j,g);
    // 기존의 `my` 배열을 복사하고, 새 객체를 추가한 새로운 배열로 업데이트
    setMy([...my, { job: j, grade: g }]);
  }

  // var [my,setMy] = useState([{ job: '전사', grade: 'SSR' }]);
  var [my,setMy] = useState([]);
  const [party] = useState([
    { job: '전사', grade: 'SSR' },
    { job: '마법사', grade: 'SR' },
    { job: '궁수', grade: 'S' },
    { job: '전사', grade: 'R' },
    { job: '궁수', grade: 'H' }
  ]);
  const [enemy] = useState([
    { job: '전사', grade: 'H' },
    { job: '전사', grade: 'H' },
    { job: '전사', grade: 'H' },
    { job: '전사', grade: 'H' },
    { job: '전사', grade: 'H' },
  ]);

  return (
    <>
      <h2>파티 1</h2>
      <CardArea>
        {party.map((character, index) => (
          <Card key={index} job={character.job} grade={character.grade} />
        ))}
      </CardArea>
      <h2>보유</h2>
      <button onClick={gacha}>카드 1뽑</button>
      <CardArea>
        {my.map((character, index) => (
          <Card key={index} job={character.job} grade={character.grade} />
        ))}
      </CardArea>
      <h2>적</h2>
      <CardArea>
        {enemy.map((character, index) => (
          <Card key={index} job={character.job} grade={character.grade} />
        ))}
      </CardArea>
    </>
  );
}

export default App;
