import React, { useState } from 'react';
import GuestPage from './components/GuestPage';
import UserPage from './components/UserPage';
import FlightDetails from './components/FlightDetails';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>✈️ Ticket Booking App</h1>
      <FlightDetails />
      <div style={{ marginTop: '20px' }}>
        {isLoggedIn ? <UserPage /> : <GuestPage />}
        <button onClick={isLoggedIn ? handleLogout : handleLogin} style={{ marginTop: '20px' }}>
          {isLoggedIn ? 'Logout' : 'Login'}
        </button>
      </div>
    </div>
  );
}

export default App;
