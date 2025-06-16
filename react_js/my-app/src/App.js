import './App.css';

function App() {
  return (
    <div className="App">
      <SimpleList />
    </div>
  );
}

function SimpleList() {
  var animals = [
    <li>고양이</li>
    ,<li>개</li>
    ,<li>너굴맨</li>
  ];

  return (
    <div>
      <h2>동물들</h2>
      <ul>
        {animals}
      </ul>
    </div>
  );
}

export default App;