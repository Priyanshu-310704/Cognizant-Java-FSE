import CohortData from './Cohort.js';
import CohortDetails from './CohortDetails.jsx';

export default function App() {
  return (
    <main className="app-shell">
      <section className="panel">
        <h1>Cohort Testing App</h1>
        <CohortDetails cohort={CohortData[0]} />
      </section>
    </main>
  );
}
