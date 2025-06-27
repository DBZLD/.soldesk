import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

function TFTSearch() {
  const navigate = useNavigate();
  const [data, setData] = useState(null);
  const [name, setName] = useState('');
  const [tag, setTag] = useState('');
  const [inputValue, setInputValue] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try{
      const response = await axios.get('http://localhost:8080/riot/getTFTRecord', {
        params: {
          playerID: name,
          playerTag: tag,
        },
      });
      setData(response.data);
      console.log(response.data);
      if(response.data?.bSuccess){
      navigate('/TFTRecord',{state:data});
      } else{
        alert("잘못된 아이디 혹은 태그입니다.");
        setInputValue('');
        setName('');
        setTag('');
      }
    } catch(error){
      console.error('Error:', error);
    }
  }

    const handleInputChange = (e) => {
      const inputString = e.target.value;
      setInputValue(inputString);
    if (inputString.includes('#')) {
      const [nameValue, tagValue] = inputString.split('#');
      setName(nameValue);
      setTag(tagValue || '');
    } else{
      setName(inputString);
      setTag('');
    }

  };
  return (
    <div>
      <h1 onClick={() => navigate('/')} style={{cursor:'pointer'}}>메인 화면으로</h1>
      <h2>TFT 전적 검색</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" placeholder='아이디#태그' onChange={handleInputChange} value={inputValue}></input>
        <input type="submit" value="검색"></input>
      </form>

    <h2>이름: {name}</h2>
    <h2>태그: {tag}</h2>
    </div>
  );
}

export default TFTSearch;