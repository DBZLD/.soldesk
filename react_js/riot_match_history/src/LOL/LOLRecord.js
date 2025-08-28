import React from 'react';
import { useNavigate } from 'react-router-dom';
import RiotAppBar from '../Util/RiotAppBar';

function LOLRecord() {
  const navigate = useNavigate();

  return (
    <div>
      <RiotAppBar/>
      <h1 onClick={() => navigate('/')} style={{cursor:'pointer'}}>메인 화면으로</h1>
      <h2>LOL 전적</h2>
    </div>
  );
}

export default LOLRecord;
