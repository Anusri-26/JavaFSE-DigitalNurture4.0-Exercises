import React from "react";
import "./App.css";

function App() {
  const officeList = [
    {
      id: 1,
      name: "Sky Tower Office",
      rent: 50000,
      address: "1st Avenue, Hyderabad",
      image:
        "https://images.unsplash.com/photo-1560448204-e02f11c3d0e2?auto=format&fit=crop&w=600&q=60"
    },
    {
      id: 2,
      name: "Green Plaza",
      rent: 75000,
      address: "Downtown, Bangalore",
      image:
        "https://images.unsplash.com/photo-1580587771525-78b9dba3b914?auto=format&fit=crop&w=600&q=60"
    },
    {
      id: 3,
      name: "Ocean View Workspace",
      rent: 60000,
      address: "Beach Road, Chennai",
      image:
        "https://images.unsplash.com/photo-1600585154340-be6161a56a0c?auto=format&fit=crop&w=600&q=60"
    }
  ];

  const getRentStyle = (rent) => {
    return {
      color: rent < 60000 ? "red" : "green",
      fontWeight: "bold"
    };
  };

  return (
    <div className="App">
      <h1>Office Space Rental App</h1>
      {officeList.map((office) => (
        <div className="card" key={office.id}>
          <img src={office.image} alt={office.name} />
          <div className="card-content">
            <h2>{office.name}</h2>
            <p style={getRentStyle(office.rent)}>Rent: ₹{office.rent}</p>
            <p>Address: {office.address}</p>
          </div>
        </div>
      ))}
    </div>
  );
}

export default App;
