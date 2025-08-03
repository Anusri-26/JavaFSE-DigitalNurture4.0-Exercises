import React, { useState } from "react";

function CurrencyConvertor() {
  const [amount, setAmount] = useState("");
  const [currency, setCurrency] = useState("");

  const handleSubmit = () => {
    // Sample fixed conversion rate (you can change this logic)
    const euro = parseFloat(amount) * 0.011;
    setCurrency(`€${euro.toFixed(2)}`);
  };

  return (
    <div>
      <h2 style={{ color: "green" }}>Currency Convertor!!!</h2>
      <label>Amount:</label>
      <br />
      <input
        type="text"
        value={amount}
        onChange={(e) => setAmount(e.target.value)}
      />
      <br />
      <label>Currency:</label>
      <br />
      <input type="text" value={currency} readOnly />
      <br />
      <button onClick={handleSubmit}>Submit</button>
    </div>
  );
}

export default CurrencyConvertor;
