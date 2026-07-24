import { useEffect, useState } from 'react';
import GitClient from './GitClient.js';

export default function App() {
  const [repositories, setRepositories] = useState([]);
  const [error, setError] = useState('');

  useEffect(() => {
    GitClient.getRepositories('techiesyed')
      .then(setRepositories)
      .catch((err) => setError(err.message));
  }, []);

  return (
    <main className="app-shell">
      <section className="panel">
        <h1>Git Client App</h1>
        {error && <p className="error">{error}</p>}
        <div className="grid">
          {repositories.map((name) => <section className="card" key={name}><h2>{name}</h2></section>)}
        </div>
      </section>
    </main>
  );
}
