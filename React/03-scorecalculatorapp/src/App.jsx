function CalculateScore({ name, school, total, goal }) {
  const average = (total / goal).toFixed(2);
  return (
    <section className="score-card">
      <h2>Score Details</h2>
      <p><strong>Name:</strong> {name}</p>
      <p><strong>School:</strong> {school}</p>
      <p><strong>Total:</strong> {total}</p>
      <p><strong>Goal:</strong> {goal}</p>
      <p className="average">Average score: {average}</p>
    </section>
  );
}

export default function App() {
  return (
    <main className="app-shell">
      <section className="panel">
        <h1>Score Calculator</h1>
        <CalculateScore name="Steeve" school="DNV Public School" total={284} goal={3} />
      </section>
    </main>
  );
}
