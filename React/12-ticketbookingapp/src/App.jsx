import { useState } from 'react';

const flights = [
  { flight: 'AI 401', from: 'Chennai', to: 'Delhi', fare: 6200 },
  { flight: '6E 244', from: 'Pune', to: 'Bengaluru', fare: 4300 },
  { flight: 'UK 818', from: 'Mumbai', to: 'Kolkata', fare: 7100 },
];

function GuestPage() {
  return <FlightList showBook={false} />;
}

function UserPage() {
  return <FlightList showBook />;
}

function FlightList({ showBook }) {
  return (
    <div className="grid">
      {flights.map((flight) => (
        <section className="card" key={flight.flight}>
          <h2>{flight.flight}</h2>
          <p>{flight.from} to {flight.to}</p>
          <p>Fare: Rs. {flight.fare}</p>
          {showBook && <button>Book Ticket</button>}
        </section>
      ))}
    </div>
  );
}

export default function App() {
  const [loggedIn, setLoggedIn] = useState(false);
  return (
    <main className="app-shell">
      <section className="panel">
        <h1>Ticket Booking App</h1>
        <div className="actions">
          {loggedIn
            ? <button className="secondary" onClick={() => setLoggedIn(false)}>Logout</button>
            : <button onClick={() => setLoggedIn(true)}>Login</button>}
        </div>
        {loggedIn ? <UserPage /> : <GuestPage />}
      </section>
    </main>
  );
}
