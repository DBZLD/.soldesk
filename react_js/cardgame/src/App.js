import axios from 'axios';
import React, { useEffect, useState } from 'react';
import './App.css';

function Card({ job, grade, xxx}) {
  return (
    <div className={`card ${job} ${grade}`} onClick={xxx}>
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
  useEffect (()=>{
    getMyCardsApi();
  },[]);
  function cardIndex(index){
    console.log(`보유카드 번호: ${index+1}`);
    alert(`보유카드 번호: ${index+1}`);
  }

  function gachaApi(){
    axios.get('http://localhost:8080/api/addCard')			
    .then(response => {		
      console.log(response.data);  // 서버로부터 받은 데이터 출력	
          // 기존의 `my` 배열을 복사하고, 새 객체를 추가한 새로운 배열로 업데이트
      setMy([...my, response.data]);
    })		
    .catch(error => {		
      console.error('Error fetching data:', error);  // 에러 처리	
    });		
  }
  function getMyCardsApi(){
    axios.get('http://localhost:8080/card/getList')			
    .then(response => {		
      console.log(response.data);  // 서버로부터 받은 데이터 출력	
          // 기존의 `my` 배열을 복사하고, 새 객체를 추가한 새로운 배열로 업데이트
      // setMy([...my, response.data]);
      setMy([...response.data]);
    })		
    .catch(error => {		
      console.error('에러:', error);  // 에러 처리	
    });		
  }
  function resetMyCardsApi(){
    axios.delete('http://localhost:8080/card/resetList')
    .then(response=>{
      console.log(response.data);
      setMy([]);
    })
    .catch(error => {		
      console.error('에러:', error);  // 에러 처리	
    });
  }
  // var [my,setMy] = useState([{ job: '전사', grade: 'SSR' }]);
  var [my,setMy] = useState([]);
  var [myParty,setMyParty] = useState([]);

  return (
    <>
      <button onClick={gachaApi}>카드 1뽑 by api</button>
      <button onClick={resetMyCardsApi}>보유 카드 리셋</button>
      <h2>보유</h2>
      <CardArea>
        {my.map((character, index) => (
          <Card key={index} job={character.job} grade={character.grade} 
            xxx={()=>cardIndex(index)}
          />
        ))}
      </CardArea>
      <h2>파티1</h2>
      <CardArea>
        {my.map((character, index) => (
          <Card key={index} job={character.job} grade={character.grade} 
            xxx={()=>cardIndex(index)}
          />
        ))}
      </CardArea>
    </>
  );
}

export default App;
