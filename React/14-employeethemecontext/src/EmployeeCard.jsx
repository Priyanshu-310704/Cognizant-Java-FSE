import { useContext } from 'react';
import ThemeContext from './ThemeContext.js';

export default function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);
  return (
    <section className="card">
      <h2>{employee.name}</h2>
      <p>{employee.role}</p>
      <button className={`${theme}-button`}>View</button>
    </section>
  );
}
