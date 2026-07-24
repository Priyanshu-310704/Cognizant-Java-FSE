import { useState } from 'react';

function ComplaintRegister() {
  const [employeeName, setEmployeeName] = useState('');
  const [complaint, setComplaint] = useState('');

  function handleSubmit(event) {
    event.preventDefault();
    const referenceNumber = Math.floor(100000 + Math.random() * 900000);
    alert(`Thanks ${employeeName}. Your complaint reference number is ${referenceNumber}.`);
    setEmployeeName('');
    setComplaint('');
  }

  return (
    <form className="card" onSubmit={handleSubmit}>
      <h2>Complaint Register</h2>
      <label>Employee Name<input required value={employeeName} onChange={(event) => setEmployeeName(event.target.value)} /></label>
      <label>Complaint<textarea required rows="5" value={complaint} onChange={(event) => setComplaint(event.target.value)} /></label>
      <button type="submit">Submit</button>
    </form>
  );
}

export default function App() {
  return <main className="app-shell"><section className="panel"><h1>Ticket Raising App</h1><ComplaintRegister /></section></main>;
}
