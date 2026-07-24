import { useState } from 'react';

function CurrencyConvertor() {
  const [rupees, setRupees] = useState('');
  const [euros, setEuros] = useState(null);

  function handleSubmit(event) {
    event.preventDefault();
    setEuros((Number(rupees) / 90).toFixed(2));
  }

  return (
    <form className="card" onSubmit={handleSubmit}>
      <h2>Currency Convertor</h2>
      <label>Indian Rupees<input value={rupees} onChange={(event) => setRupees(event.target.value)} /></label>
      <button type="submit">Convert</button>
      {euros !== null && <p>Euro value: EUR {euros}</p>}
    </form>
  );
}

export default function App() {
  const [count, setCount] = useState(0);
  const [message, setMessage] = useState('');

  function sayHello() {
    setMessage('Hello. Counter increased.');
  }

  function increment() {
    setCount((value) => value + 1);
    sayHello();
  }

  function decrement() {
    setCount((value) => value - 1);
  }

  function sayWelcome(text) {
    setMessage(text);
  }

  function onPress(event) {
    setMessage(`I was clicked by ${event.type}`);
  }

  return (
    <main className="app-shell">
      <section className="panel">
        <h1>Event Examples</h1>
        <section className="card">
          <h2>Counter: {count}</h2>
          <div className="actions">
            <button onClick={increment}>Increment</button>
            <button className="secondary" onClick={decrement}>Decrement</button>
            <button onClick={() => sayWelcome('welcome')}>Say Welcome</button>
            <button className="secondary" onClick={onPress}>OnPress</button>
          </div>
          <p>{message}</p>
        </section>
        <CurrencyConvertor />
      </section>
    </main>
  );
}
