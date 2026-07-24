const players = [
  { name: 'Sachin', score: 95 }, { name: 'Dhoni', score: 86 }, { name: 'Virat', score: 68 },
  { name: 'Rohit', score: 82 }, { name: 'Yuvraj', score: 59 }, { name: 'Raina', score: 74 },
  { name: 'Hardik', score: 64 }, { name: 'Jadeja', score: 77 }, { name: 'Bumrah', score: 42 },
  { name: 'Shami', score: 38 }, { name: 'Gill', score: 91 },
];

const indianPlayers = ['Sachin', 'Dhoni', 'Virat', 'Rohit', 'Yuvraj', 'Raina'];
const t20Players = ['Hardik', 'Suryakumar', 'Bumrah'];
const ranjiTrophyPlayers = ['Sarfaraz', 'Rahane', 'Shaw'];

function ListofPlayers() {
  const belowSeventy = players.filter((player) => player.score < 70);
  return (
    <div className="grid">
      <section className="card">
        <h2>All Players</h2>
        {players.map((player) => <p key={player.name}>{player.name}: {player.score}</p>)}
      </section>
      <section className="card">
        <h2>Scores Below 70</h2>
        {belowSeventy.map((player) => <p key={player.name}>{player.name}: {player.score}</p>)}
      </section>
    </div>
  );
}

function IndianPlayers() {
  const [first, second, third, fourth, fifth, sixth] = indianPlayers;
  const oddTeam = [first, third, fifth];
  const evenTeam = [second, fourth, sixth];
  const mergedPlayers = [...t20Players, ...ranjiTrophyPlayers];
  return (
    <div className="grid">
      <section className="card"><h2>Odd Team Players</h2>{oddTeam.map((name) => <p key={name}>{name}</p>)}</section>
      <section className="card"><h2>Even Team Players</h2>{evenTeam.map((name) => <p key={name}>{name}</p>)}</section>
      <section className="card"><h2>Merged Players</h2>{mergedPlayers.map((name) => <p key={name}>{name}</p>)}</section>
    </div>
  );
}

export default function App() {
  const flag = true;
  return (
    <main className="app-shell">
      <section className="panel">
        <h1>Cricket App</h1>
        {flag ? <ListofPlayers /> : <IndianPlayers />}
      </section>
    </main>
  );
}
