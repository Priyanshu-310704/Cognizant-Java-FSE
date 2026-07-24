import { BrowserRouter, Link, Navigate, Route, Routes, useParams } from 'react-router-dom';
import trainers from './TrainersMock.js';

function Home() {
  return <section className="card"><h2>Academy Trainers</h2><p>Trainer expertise is maintained in this single page application.</p></section>;
}

function TrainersList() {
  return (
    <section className="card">
      <h2>Trainers List</h2>
      <ul>
        {trainers.map((trainer) => (
          <li key={trainer.trainerId}><Link to={`/trainers/${trainer.trainerId}`}>{trainer.name}</Link></li>
        ))}
      </ul>
    </section>
  );
}

function TrainerDetail() {
  const { id } = useParams();
  const trainer = trainers.find((item) => String(item.trainerId) === id);
  if (!trainer) return <section className="card"><h2>Trainer not found</h2></section>;
  return (
    <section className="card">
      <h2>{trainer.name}</h2>
      <p><strong>Email:</strong> {trainer.email}</p>
      <p><strong>Phone:</strong> {trainer.phone}</p>
      <p><strong>Technology:</strong> {trainer.technology}</p>
      <p><strong>Skills:</strong> {trainer.skills.join(', ')}</p>
    </section>
  );
}

export default function App() {
  return (
    <BrowserRouter>
      <main className="app-shell">
        <section className="panel">
          <h1>Trainers App</h1>
          <nav className="actions">
            <Link to="/">Home</Link>
            <Link to="/trainers">Trainers</Link>
          </nav>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/trainers" element={<TrainersList />} />
            <Route path="/trainers/:id" element={<TrainerDetail />} />
            <Route path="*" element={<Navigate to="/" replace />} />
          </Routes>
        </section>
      </main>
    </BrowserRouter>
  );
}
