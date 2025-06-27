import React from 'react';
import { Routes, Route } from 'react-router-dom';
import MainPage from './MainPage';
import TFTMain from './TFT/TFTMain';
import TFTRecord from './TFT/TFTRecord';
import LOLSearch from './LOL/LOLSearch';
import LOLHistory from './LOL/LOLHistory';

function Locate() {
  return (
    <Routes>
      <Route path="/" element={<MainPage />} />
      <Route path="/TFTRecord" element={<TFTRecord />} />
      <Route path="/TFTMain" element={<TFTMain/>} />
      <Route path="/LOLSearch" element={<LOLSearch/>} />
      <Route path="/LOLHistory" element={<LOLHistory/>} />
    </Routes>
  );
}

export default Locate;