import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

function TFTSearch() {
  const navigate = useNavigate();
  const [data,setData] = useState(null);
  const handleSubmit = async (e) => {
    e.preventDefault();
    try{
      const response = await axios.get('http://localhost:8080/mi/riot/historyTFT', {
        params: {
          playerID: name,
          playerTag: tag,
        },
      });
      setData(response.data);
      console.log(response.data);
    }catch(error){
      console.error('Error:', error);
    }
    data.bError?navigate('/TFTHistory'):console.log("잘못된 이름입니다.")
  }

  const [name, setName] = useState('');
  const [tag, setTag] = useState('');

    const handleInputChange = (e) => {
    const inputString = e.target.value;
    if (inputString.includes('#')) {
      const [nameValue, tagValue] = inputString.split('#');
      setName(nameValue);
      setTag(tagValue);
    } else{
      setName(inputString);
    }
  };
  return (
    <div>
      <h1 onClick={() => navigate('/')} style={{cursor:'pointer'}}>메인 화면으로</h1>
      <h2>TFT 전적 검색</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" placeholder='아이디#태그' onChange={handleInputChange}></input>
        <input type="submit" value="검색"></input>
      </form>

    <h2>이름: {name}</h2>
    <h2>태그: {tag}</h2>
    </div>
  );
}

export default TFTSearch;