import './App.css';
import React, { useState } from 'react';

function App() {
  const [catName, setCatName] = useState('');        // 고양이 이름 상태
  const [likesCats, setLikesCats] = useState(false); // 체크박스 상태 (고양이 좋아하는지 여부)
  const [catType, setCatType] = useState('');        // 라디오 버튼 상태 (고양이 종류)
  const [furColor, setFurColor] = useState('');      // 셀렉트 박스 상태 (고양이 털 색깔)
  const [catAge, setCatAge] = useState(1);           // 슬라이더 상태 (고양이 나이)
  const [favoriteColor, setFavoriteColor] = useState('#ffffff'); // 고양이가 좋아하는 색상
  const [catBirthDate, setCatBirthDate] = useState('');          // 고양이 생일
  const [feedingTime, setFeedingTime] = useState('');            // 밥 줄 시간

  // 핸들러들
  const handleChange = (e) => setCatName(e.target.value);
  const handleCheckboxChange = (e) => setLikesCats(e.target.checked);
  const handleRadioChange = (e) => setCatType(e.target.value);
  const handleSelectChange = (e) => setFurColor(e.target.value);
  const handleSliderChange = (e) => setCatAge(e.target.value);
  const handleColorChange = (e) => setFavoriteColor(e.target.value); // 좋아하는 색상
  const handleDateChange = (e) => setCatBirthDate(e.target.value);   // 고양이 생일
  const handleTimeChange = (e) => setFeedingTime(e.target.value);    // 밥 줄 시간

  const handleSubmit = (e) => {
    e.preventDefault(); // 폼 제출 시 기본 동작 방지
    alert(`
      고양이 이름: ${catName}
      고양이를 좋아하나요?: ${likesCats ? "네" : "아니요"}
      고양이 종류: ${catType}
      고양이 털 색깔: ${furColor}
      고양이 나이: ${catAge}살
      고양이 좋아하는 색상: ${favoriteColor}
      고양이 생일: ${catBirthDate}
      밥 줄 시간: ${feedingTime}
    `);
  };

  return (
    <div>
      <h2>고양이 이름 짓기</h2>
      <form onSubmit={handleSubmit}>
        {/* 고양이 이름 */}
        <input
          type="text"
          name="name"
          value={catName}
          onChange={handleChange}
          placeholder="고양이 이름 입력"
        />

        {/* 체크박스 */}
        <div>
          <label>
            <input
              type="checkbox"
              checked={likesCats}
              onChange={handleCheckboxChange}
            />
            고양이를 좋아하나요?
          </label>
        </div>

        {/* 라디오 버튼 */}
        <div>
          <h3>고양이 종류를 선택하세요:</h3>
          <label>
            <input
              type="radio"
              value="러시안블루"
              checked={catType === '러시안블루'}
              onChange={handleRadioChange}
            />
            러시안블루
          </label>
          <label>
            <input
              type="radio"
              value="샴"
              checked={catType === '샴'}
              onChange={handleRadioChange}
            />
            샴
          </label>
          <label>
            <input
              type="radio"
              value="페르시안"
              checked={catType === '페르시안'}
              onChange={handleRadioChange}
            />
            페르시안
          </label>
        </div>

        {/* 셀렉트 박스 */}
        <div>
          <h3>고양이 털 색깔을 선택하세요:</h3>
          <select value={furColor} onChange={handleSelectChange}>
            <option value="">색깔 선택</option>
            <option value="검정">검정</option>
            <option value="흰색">흰색</option>
            <option value="회색">회색</option>
            <option value="갈색">갈색</option>
          </select>
        </div>

        {/* 슬라이더 (고양이 나이 입력) */}
        <div>
          <h3>고양이 나이: {catAge}살</h3>
          <input
            type="range"
            min="1"
            max="20"
            value={catAge}
            onChange={handleSliderChange}
          />
        </div>

        {/* 색상 선택 (고양이가 좋아하는 색상) */}
        <div>
          <h3>고양이가 좋아하는 색상:</h3>
          <input
            type="color"
            value={favoriteColor}
            onChange={handleColorChange}
          />
        </div>

        {/* 생일 입력 */}
        <div>
          <h3>고양이 생일을 선택하세요:</h3>
          <input
            type="date"
            value={catBirthDate}
            onChange={handleDateChange}
          />
        </div>

        {/* 밥 줄 시간 */}
        <div>
          <h3>밥 줄 시간:</h3>
          <input
            type="time"
            value={feedingTime}
            onChange={handleTimeChange}
          />
        </div>

        <input type="submit" value="제출" />
      </form>

      <h2>고양이 이름: {catName}</h2>
      <h2>고양이를 좋아하나요?: {likesCats ? "네" : "아니요"}</h2>
      <h2>선택한 고양이 종류: {catType}</h2>
      <h2>선택한 털 색깔: {furColor}</h2>
      <h2>고양이 나이: {catAge}살</h2>
      <h2>고양이 좋아하는 색상: {favoriteColor}</h2>
      <h2>고양이 생일: {catBirthDate}</h2>
      <h2>밥 줄 시간: {feedingTime}</h2>
    </div>
  );
}

export default App;
