import React, { useState } from "react";
import CurrencyConvertor from "./CurrencyConvertor";

function App() {
  const [count, setCount] = useState(0);

  const increment = () => {
    setCount(count + 1);
    alert("Hello Member1!");
  };

  const decrement = () => {
    setCount(count - 1);
  };

  const sayWelcome = (message) => {
    alert(message);
  };

  const handleClick = () => {
    alert("I was clicked");
  };

  return (
    <div>
      <p>{count}</p>

      <button onClick={increment}>Increment</button>
      <br />
      <button onClick={decrement}>Decrement</button>
      <br />
      <button onClick={() => sayWelcome("welcome")}>Say welcome</button>
      <br />
      <button onClick={handleClick}>Click on me</button>

      <CurrencyConvertor />
    </div>
  );
}

export default App;
