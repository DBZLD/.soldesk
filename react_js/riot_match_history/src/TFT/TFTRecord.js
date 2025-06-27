import React from 'react';
import { useNavigate } from 'react-router-dom';

function TFTHistory() {
  const navigate = useNavigate();

  return (
    <div>
      <h1 onClick={() => navigate('/TFTMain')} style={{cursor:'pointer'}}>TFT 메인 화면으로</h1>
      <h2>TFT 전적</h2>
    </div>
  );
}

export default TFTHistory;
