import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import axios from 'axios';
import TFTMatchAccordion from './TFTMatchAccordion';

function TFTRecord() {
  const navigate = useNavigate();
  const location = useLocation();
  const searchParams = new URLSearchParams(location.search);

  const pId = searchParams.get('id');
  const pTag = searchParams.get('tag');

  const [data, setData] = useState(null);
  const [isInvalid, setIsInvalid] = useState(false);
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8080/riot/getTFTRecord', {
          params: {
            playerID: pId,
            playerTag: pTag,
          },
        });
        setData(response.data);
        console.log(response.data);

        if (response.data?.bSuccess) {
          setIsInvalid(false);
        } else {
          setIsInvalid(true);
        }
      } catch (error) {
        console.error('Error:', error);
      }
    };
    fetchData();
  }, [pId, pTag]);

  // isInvalid가 true일때~
  const [id, setId] = useState(pId);
  const [tag, setTag] = useState(pTag);
  const handleSubmit = async (e) => {
    e.preventDefault();
    navigate(`/TFTRecord?id=${id}&tag=${tag}`);
  }
  const handleInputChange = (e) => {
    const inputString = e.target.value;
    if (inputString.includes('#')) {
      const [idValue, tagValue] = inputString.split('#');
      setId(idValue);
      setTag(tagValue || '');
    } else {
      setId(inputString);
      setTag('');
    }
  };
  //~isInvalid가 true일때
  return (
    <div>
      {isInvalid ? (
        <>
          <h1 onClick={() => navigate('/TFTMain')} style={{ cursor: 'pointer' }}>TFT 메인 화면으로</h1>
          <h2>잘못된 아이디 또는 태그입니다.</h2>
          <form onSubmit={handleSubmit}>
            <input type="text" placeholder='아이디#태그' onChange={handleInputChange} defaultValue={`${pId}${pTag ? `#${pTag}` : ''}`}></input>
            <input type="submit" value="검색"></input>
          </form>
        </>
      ) : (
        <>
          <h1 onClick={() => navigate('/TFTMain')} style={{ cursor: 'pointer' }}>TFT 메인 화면으로</h1>
          <h2>TFT 전적</h2>
          <TFTMatchAccordion/>
        </>
      )}
    </div>
  );
}

export default TFTRecord;
