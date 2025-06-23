// src/components/WorldMap/WorldMap.js
import React from 'react';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';

import './WorldMap.css'; // 스타일 파일 임포트

import L from 'leaflet'; // L.icon을 사용하기 위한 임포트

// 마커 이미지 경로 설정
const customIcon = new L.Icon({
  iconUrl: '/resources/img/marker.png', // public 폴더에 있는 이미지 경로
  iconSize: [32, 32], // 마커 이미지 크기
  iconAnchor: [16, 32], // 마커 이미지의 앵커 위치 (이미지 하단 가운데)
  popupAnchor: [0, -32], // 팝업 위치 (마커 위에 표시)
});

function WorldMap() {
  const position = [37.436999, 127.127331]; // 예시 위치: 서울, 대한민국, 성남
  const position2 = [38.7169, -9.1395];  // 예시 위치: 리스본, 포르투갈


  // const bounds = [
  //   [38.6, -10], // 남서쪽
  //   [38.8, -8]  // 북동쪽
  // ];  


  return (
    <div style={{ width: '100%', height: '1200px' }}>
      {/* zoom= 처음 줌 레벨 */}
      <MapContainer center={position} zoom={13} style={{ width: '100%', height: '100%' }} >
        <TileLayer
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
          minZoom={4} // 최소 줌 레벨
          maxZoom={24} // 최대 줌 레벨 24가 최대로 보임.
        />
        {/* <TileLayer
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
          tileSize={512} // 타일 크기 최적화
          minZoom={5}    // 최소 줌 레벨
          maxZoom={19}   // 최대 줌 레벨
        /> */}

        {/* 한국어 타일 레이어 사용 (안됨) */}
        {/* <TileLayer
          url="https://{s}.tile.openstreetmap.kr/{z}/{x}/{y}.png"
          attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        />         */}
        {/* <TileLayer
          url="https://{s}.basemaps.cartocdn.com/light_all/{z}/{x}/{y}.png"
          attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        />         */}
        <Marker position={position} icon={customIcon}>
          <Popup>본부</Popup>
        </Marker>
        <Marker position={position2} icon={customIcon}>
          <Popup>리스본</Popup>
        </Marker>
      </MapContainer>
    </div>
  );
}

export default WorldMap;
