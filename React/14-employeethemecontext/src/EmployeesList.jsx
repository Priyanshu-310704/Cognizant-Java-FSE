import EmployeeCard from './EmployeeCard.jsx';

export default function EmployeesList({ employees }) {
  return (
    <div className="grid">
      {employees.map((employee) => <EmployeeCard employee={employee} key={employee.id} />)}
    </div>
  );
}
