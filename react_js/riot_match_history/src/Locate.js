import React from 'react';
import { Routes, Route } from 'react-router-dom';
import MainPage from './MainPage';
import TFTMain from './TFT/TFTMain';
import TFTRecord from './TFT/TFTRecord';
import LOLMain from './LOL/LOLMain';
import LOLRecord from './LOL/LOLRecord';
import VALMain from './VAL/VALMain';
import VALRecord from './VAL/VALRecord';
import COMMain from './COM/COMMain';
import SignInPage from './SignInPage';
import SignUpPage from './SignUpPage';
import MyPage from './MyPage';

function Locate() {
  return (
    <Routes>
      <Route path="/" element={<MainPage />} />
      <Route path="/TFTMain" element={<TFTMain />} />
      <Route path="/TFTRecord" element={<TFTRecord />} />
      <Route path="/LOLMain" element={<LOLMain />} />
      <Route path="/LOLRecord" element={<LOLRecord />} />
      <Route path="/VALMain" element={<VALMain />} />
      <Route path="/VALRecord" element={<VALRecord />} />
      <Route path="/COMMain" element={<COMMain />} />
      <Route path="/SignInPage" element={<SignInPage />} />
      <Route path="/SignUpPage" element={<SignUpPage />} />
      <Route path="/MyPage" element={<MyPage />} />
    </Routes>
  );
}

export default Locate;