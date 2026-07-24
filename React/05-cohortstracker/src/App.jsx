import CohortData from './Cohort.js';
import CohortDetails from './CohortDetails.jsx';

export default function App() {
  return (
    <main className="app-shell">
      <section className="panel">
        <h1>Cohorts Tracker</h1>
        {CohortData.map((cohort) => <CohortDetails cohort={cohort} key={cohort.code} />)}
      </section>
    </main>
  );
}
