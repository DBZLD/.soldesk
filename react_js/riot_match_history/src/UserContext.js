import { createContext, useState, useEffect } from 'react';

export const UserContext = createContext();

export const UserProvider = ({ children }) => {
  const [userId, setUserId] = useState('');  //페이지 계정 아이디
  const [isLoggedIn, setIsLoggedIn] = useState(false);  //로그인 여부
  const [riotAccount, setRiotAccount] = useState(''); //페이지 계정 라이엇 아이디

  // 페이지 변경 시에 기존 로그인 정보 유지
  useEffect(() => {
    const savedUserId = localStorage.getItem('userId');
    const savedIsLoggedIn = localStorage.getItem('isLoggedIn');
    const savedRiotAccount = localStorage.getItem('riotAccount');

    if (savedUserId && savedIsLoggedIn === 'true') {
      setUserId(savedUserId);
      setIsLoggedIn(true);
      setRiotAccount(savedRiotAccount || '');
    }
  }, []);

  useEffect(() => {
    if (isLoggedIn) { // 로그인시 userId, isLogginedIn, riotAccount값 설정
      localStorage.setItem('userId', userId);
      localStorage.setItem('isLoggedIn', 'true');
      localStorage.setItem('riotAccount', riotAccount);
    } else { // 비로그인시 초기화
      localStorage.removeItem('userId');
      localStorage.removeItem('isLoggedIn');
      localStorage.removeItem('riotAccount');
    }
  }, [isLoggedIn, userId, riotAccount]);

  return (
    <UserContext.Provider value={{ userId, setUserId, isLoggedIn, setIsLoggedIn, riotAccount, setRiotAccount }}>
      {children}
    </UserContext.Provider>
  );
};
