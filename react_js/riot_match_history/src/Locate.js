import React from 'react';
import { Routes, Route } from 'react-router-dom';
import MainPage from './MainPage';
import TFTMain from './TFT/TFTMain';
import TFTRecord from './TFT/TFTRecord';
import LOLMain from './LOL/LOLMain';
import LOLRecord from './LOL/LOLRecord';

function Locate() {
  return (
    <Routes>
      <Route path="/" element={<MainPage />} />
      <Route path="/TFTRecord" element={<TFTRecord />} />
      <Route path="/TFTMain" element={<TFTMain/>} />
      <Route path="/LOLMain" element={<LOLMain/>} />
      <Route path="/LOLRecord" element={<LOLRecord/>} />
    </Routes>
  );
}

export default Locate;