import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import axios from 'axios';
import TFTMatchAccordion from './TFTMatchAccordion';
import '../reset.css';
import './TFTcommon.css';
import RiotAppBar from '../RiotAppBar';

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
            playerID: pId.replace(/\s/g, ""),
            playerTag: pTag.replace(/\s/g, ""),
          },
        });
        console.log(response.data);
        setData(response.data);
        if (response.data?.bSuccess) {
          setIsInvalid(false);
        } else {
          setIsInvalid(true);
        }
      } catch (error) {
        console.error('Error:', error);
        setIsInvalid(true);
        setData(null);
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
  function RegaliaBox({ title, data, isTurbo = false }) {
  return (
    <div className="rankBox">
      <h1 className="regaliaType">{title}</h1>
      <img className="regaliaImg" src={data.imgURL} alt="playerRegaliaImg" />
      <h2 className="regaliaTier">{data.tier} {data.rank}</h2>
      {data.tier !== "랭크 없음" && (
        <>
          <h2 className="regaliaPoint">{data.point}{isTurbo ? "점" : "LP"}</h2>
          <h2 className="regaliaWL">{data.win}승 {data.lose}패</h2>
        </>
      )}
    </div>
  );
}
  //~isInvalid가 true일때
  return (
    <div className='body'>
      <RiotAppBar/>
      {isInvalid ? (
        <div className='center'>
          <h2>잘못된 아이디 또는 태그입니다.</h2>
          <form onSubmit={handleSubmit}>
            <input type="text" placeholder='아이디#태그' onChange={handleInputChange} defaultValue={`${pId}${pTag ? `#${pTag}` : ''}`}></input>
            <input type="submit" value="검색"></input>
          </form>
        </div>
      ) : data ? (
        <div className='center'>
          <div className='profileArea'>
            <div className='profileBox'>
          <img id='icon' src={data.playerProfileInfo.iconURL} alt='playerProfileIcon'></img>
          <h4 id='level'>{data.playerProfileInfo.level}</h4>
            </div>
          <h1 id='name'>{data.playerProfileInfo.name}#{data.playerProfileInfo.tag}</h1>
          <button id='refresh'>전적 갱신</button>
          </div>
          <div className='rankArea'>
            <RegaliaBox title="랭크" data={data.playerRankInfo.rank} />
            <RegaliaBox title="더블 업" data={data.playerRankInfo.doubleUp} />
            <RegaliaBox title="초고속 모드" data={data.playerRankInfo.turbo} isTurbo />  
          </div>
          <div className='recordArea'>
            {data.matchInfo.slice(0, data.matchInfo.length).map((match, index) => (
            <TFTMatchAccordion key={index} data={match} />
            ))}
          </div>
        </div>
      ) : (
        <h2>데이터 불러오는 중...</h2>
      )}
    </div>
  );
}

export default TFTRecord;
