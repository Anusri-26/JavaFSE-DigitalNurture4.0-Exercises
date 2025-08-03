import React from 'react';
import ListofPlayers from './components/ListofPlayers';
import Scorebelow70 from './components/Scorebelow70';
import OddPlayers from './components/OddPlayers';
import EvenPlayers from './components/EvenPlayers';
import ListofIndianPlayers from './components/ListofIndianPlayers';

function App() {
  const players = [
    { name: "Mr. Jack", score: 50 },
    { name: "Mr. Michael", score: 70 },
    { name: "Mr. John", score: 40 },
    { name: "Mr. Ann", score: 61 },
    { name: "Mr. Elisabeth", score: 61 },
    { name: "Mr. Sachin", score: 95 },
    { name: "Mr. Dhoni", score: 100 },
    { name: "Mr. Virat", score: 84 },
    { name: "Mr. Jadeja", score: 64 },
    { name: "Mr. Raina", score: 75 },
    { name: "Mr. Rohit", score: 80 }
  ];

  const IndianTeam = [
    "Sachin1",
    "Dhoni2",
    "Virat3",
    "Rohit4",
    "Yuvraj5",
    "Raina6"
  ];

  const IndianPlayers = [
    "Mr. First Player",
    "Mr. Second Player",
    "Mr. Third Player",
    "Mr. Fourth Player",
    "Mr. Fifth Player",
    "Mr. Sixth Player"
  ];

  return (
    <div>
      <h1>List of Players</h1>
      <ListofPlayers players={players} />
      <hr />

      <h1>List of Players having Scores Less than 70</h1>
      <Scorebelow70 players={players} />
      <hr />

      <h1>Indian Team</h1>
      <h2>Odd Players</h2>
      <OddPlayers IndianTeam={IndianTeam} />
      <hr />

      <h2>Even Players</h2>
      <EvenPlayers IndianTeam={IndianTeam} />
      <hr />

      <h1>List of Indian Players Merged:</h1>
      <ListofIndianPlayers IndianPlayers={IndianPlayers} />
    </div>
  );
}

export default App;
