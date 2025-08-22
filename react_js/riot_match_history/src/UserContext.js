import { createContext, useState, useEffect } from 'react';

export const UserContext = createContext();

export const UserProvider = ({ children }) => {
  const [userId, setUserId] = useState('');
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [riotAccount, setRiotAccount] = useState('');

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
    if (isLoggedIn) {
      localStorage.setItem('userId', userId);
      localStorage.setItem('isLoggedIn', 'true');
      localStorage.setItem('riotAccount', riotAccount);
    } else {
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
