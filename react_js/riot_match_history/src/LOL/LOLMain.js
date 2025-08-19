import React from 'react';
import { useNavigate } from 'react-router-dom';
import RiotAppBar from '../RiotAppBar';

function LOLMain() {
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    navigate('/LOLRecord');
  }
  return (
    <div>
      <RiotAppBar/>
      <h1 onClick={() => navigate('/')} style={{cursor:'pointer'}}>메인 화면으로</h1>
      <h2>LOL 전적 검색</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" name="id" placeholder='아이디'></input>
        <input type="text" name="tag" placeholder='태그'></input>
        <input type="submit" value="검색"></input>
      </form>

    </div>
  );
}

export default LOLMain;