import React, { useEffect, useState } from 'react';
import axios from 'axios';

function App(){
  // 서버로부터 받은 데이터를 저장할 state를 선언
  const [catData, setCatData] = useState(null);

  // 데이터를 주기적으로 가져오는 함수를 정의
  const fetchData = async () => {
    try {
      // axios를 사용하여 서버로부터 데이터를 받아옴
      const response = await axios.get('http://localhost:8080/api/xw');
      // 받아온 데이터를 state에 저장하여 화면을 갱신
      setCatData(response.data);
    } catch (error) {
      // 만약 데이터를 가져오다가 오류가 발생하면, 콘솔에 출력
      console.error('Error fetching data:', error);
    }
  };

  // useEffect를 사용하여 컴포넌트가 마운트될 때와 주기적으로 데이터를 받아오는 동작을 설정
  useEffect(() => {
    // 컴포넌트가 처음 렌더링될 때 데이터를 한 번 받아옴
    fetchData();

    // 30초마다 fetchData 함수를 실행하도록 setInterval 설정 (30초 = 30000ms)
    const intervalId = setInterval(fetchData, 5000);

    // 컴포넌트가 언마운트(사라질 때)되면 setInterval을 정리하여 메모리 누수를 방지
    return () => clearInterval(intervalId);
  }, []); // 빈 배열을 넣으면 처음 마운트될 때 한 번만 실행하고, 그 이후로는 30초마다 실행됨

  // 데이터를 받아오기 전에는 로딩 메시지를 보여줌
  if (!catData) {
    return <div>Loading...</div>;
  }

  // 데이터를 받아왔을 때 화면에 보여줄 UI
  return (
    <div>
      <h2>Cat Information (Updated every 5 seconds)</h2>
      <p>Name : {catData.catName}</p>
      <p>WeaponName : {catData.myWeapon.name}</p>
      <p>WeaponAttack : {catData.myWeapon.atk}</p>
    </div>
  );
};

export default App;