import React from 'react';
import './App.css';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore
        name="Akhila"
        school="SVECW"
        total={470}
        goal="Become a Designer"
      />
    </div>
  );
}

export default App;
