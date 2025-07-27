import React from 'react';
import '../App.css'; 

function CalculateScore(props) {
  const average = props.total / 5;

  return (
    <div className="score-container">
      <h2>Student Score Calculator</h2>
      <p><span className="label name">Name:</span> <span className="value">{props.name}</span></p>
      <p><span className="label school">School:</span> <span className="value">{props.school}</span></p>
      <p><span className="label total">Total Marks:</span> <span className="value">{props.total}</span></p>
      <p><span className="label goal">Goal:</span> <span className="value">{props.goal}</span></p>
      <p><span className="label score">Average Score:</span> <span className="value">{average}</span></p>
    </div>
  );
}

export default CalculateScore;
  
