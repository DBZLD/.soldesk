import React from 'react';
import { useNavigate } from 'react-router-dom';

function MainPage() {
  const navigate = useNavigate();

  return (
    <div>
        <h1>메인 화면</h1>
        <button onClick={() => navigate('/TFTMain')}>TFT 전적 검색</button>
        <button onClick={() => navigate('/LOLMain')}>롤 전적 검색</button>
        <button onClick={() => navigate('/VALMain')}>발로란트 전적 검색</button>
        
    </div>
  );
}

export default MainPage;