import React from 'react';

function OddPlayers({ IndianTeam }) {
  const oddLabels = ["First", "Third", "Fifth"];
  const oddPlayers = IndianTeam.filter((_, index) => index % 2 === 0);

  return (
    <ul>
      {oddPlayers.map((player, index) => (
        <li key={index}>{oddLabels[index]} : {player}</li>
      ))}
    </ul>
  );
}

export default OddPlayers;
