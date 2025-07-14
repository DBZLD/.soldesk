import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import axios from 'axios';
import TFTMatchAccordion from './TFTMatchAccordion';
import '.././common.css';

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
    <div className='main'>
      {isInvalid ? (
        <>
          <h1 onClick={() => navigate('/TFTMain')} style={{ cursor: 'pointer' }}>TFT 메인 화면으로</h1>
          <h2>잘못된 아이디 또는 태그입니다.</h2>
          <form onSubmit={handleSubmit}>
            <input type="text" placeholder='아이디#태그' onChange={handleInputChange} defaultValue={`${pId}${pTag ? `#${pTag}` : ''}`}></input>
            <input type="submit" value="검색"></input>
          </form>
        </>
      ) : data ? (
        <>
          <h1 onClick={() => navigate('/TFTMain')} style={{ cursor: 'pointer' }}>TFT 메인 화면으로</h1>
          <div className='profileArea'>
          <img id='icon' src={data.playerProfileInfo.iconURL} alt='playerProfileIcon'></img>
          <h4 id='level'>{data.playerProfileInfo.level}</h4>
          <h1 id='name'>{data.playerProfileInfo.name}#{data.playerProfileInfo.tag}</h1>
          <button id='refresh'>전적 갱신</button>
          </div>
          <div className='rankArea'>
            <div className='rankBox'>
              <h1 id='regaliaType'>랭크</h1>
              <img id='regaliaImg' src={data.playerRankInfo.rank.imgURL} alt='playerRegaliaImg'></img>
              <h2 id='regaliaTier'>{data.playerRankInfo.rank.tier} {data.playerRankInfo.rank.rank}</h2>
              <h2 id='regaliaPoint'>{data.playerRankInfo.rank.point}LP</h2>
              <h2 id='regaliaRank'></h2>
            </div>
            <div className='rankBox'>
              <h1 id='regaliaType'>더블 업</h1>
              <img id='regaliaImg' src={data.playerRankInfo.doubleUp.imgURL} alt='playerRegaliaImg'></img>
              <h2 id='regaliaTier'>{data.playerRankInfo.doubleUp.tier} {data.playerRankInfo.doubleUp.rank}</h2>
              <h2 id='regaliaPoint'>{data.playerRankInfo.doubleUp.point}LP</h2>
              <h2 id='regaliaRank'></h2>
            </div>
            <div className='rankBox'>
              <h1 id='regaliaType'>초고속 모드</h1>
              <img id='regaliaImg' src={data.playerRankInfo.turbo.imgURL} alt='playerRegaliaImg'></img>
              <h2 id='regaliaTier'>{data.playerRankInfo.turbo.tier} {data.playerRankInfo.turbo.rank}</h2>
              <h2 id='regaliaPoint'>{data.playerRankInfo.turbo.point}점</h2>
              <h2 id='regaliaRank'></h2>
            </div>
          </div>
          <div className='recordArea'>
          <TFTMatchAccordion/>
          </div>
        </>
      ) : (
        <h2>데이터 불러오는 중...</h2>

      )}
    </div>
  );
}

export default TFTRecord;
