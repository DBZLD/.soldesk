import React from 'react';
import { Routes, Route } from 'react-router-dom';
import MainPage from './MainPage';
import TFTSearch from './TFT/TFTSearch';
import TFTHistory from './TFT/TFTHistory';
import LOLSearch from './LOL/LOLSearch';
import LOLHistory from './LOL/LOLHistory';

function Locate() {
  return (
    <Routes>
      <Route path="/" element={<MainPage />} />
      <Route path="/TFTHistory" element={<TFTHistory />} />
      <Route path="/TFTSearch" element={<TFTSearch/>} />
      <Route path="/LOLSearch" element={<LOLSearch/>} />
      <Route path="/LOLHistory" element={<LOLHistory/>} />
    </Routes>
  );
}

export default Locate;