import axios from 'axios';									

axios.get('https://ddragon.leagueoflegends.com/cdn/15.12.1/data/ko_KR/tft-regalia.json')								
  .then(response => {							
    console.log(response.data);  // 서버로부터 받은 데이터 출력						
  })							
  .catch(error => {							
    console.error('Error fetching data:', error);  // 에러 처리						
  })						
function App() {

  return (
    <>
    cat
    </>
  );
}
export default App;
