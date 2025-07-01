import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function TFTSearch() {
  const navigate = useNavigate();
  const [id, setId] = useState('');
  const [tag, setTag] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    navigate(`/TFTRecord?id=${id}&tag=${tag}`);
  }

    const handleInputChange = (e) => {
      const inputString = e.target.value;
    if (inputString.includes('#')) {
      const [idValue, tagValue] = inputString.split('#');
      setId(idValue);
      setTag(tagValue || '');
    } else{
      setId(inputString);
      setTag('');
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

    <h2>이름: {id}</h2>
    <h2>태그: {tag}</h2>
    </div>
  );
}

export default TFTSearch;