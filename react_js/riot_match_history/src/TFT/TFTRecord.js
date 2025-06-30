import React, { useState } from 'react';
import { useNavigate} from 'react-router-dom';

function TFTHistory() {
  const navigate = useNavigate();
  const [data,setData] = useState[null];
      // try{
      //   const response = await axios.get('http://localhost:8080/riot/getTFTRecord', {
      //     params: {
      //       playerID: name,
      //       playerTag: tag,
      //     },
      //   });
      //   setData(response.data);
      //   console.log(response.data);
      //   if(response.data?.bSuccess){
      //   } else{
      //     alert("잘못된 아이디 혹은 태그입니다.");
      //     setInputValue('');
      //     setName('');
      //     setTag('');
      //   }
      // } catch(error){
      //   console.error('Error:', error);
      // }
  console.log({data});
  return (
    <div>
      <h1 onClick={() => navigate('/TFTMain')} style={{cursor:'pointer'}}>TFT 메인 화면으로</h1>
      <h2>TFT 전적</h2>
    </div>
  );
}

export default TFTHistory;
