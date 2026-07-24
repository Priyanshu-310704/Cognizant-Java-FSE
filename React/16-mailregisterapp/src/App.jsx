import { useState } from 'react';

function Register() {
  const [form, setForm] = useState({ name: '', email: '', password: '' });
  const [errors, setErrors] = useState({});
  const [submitted, setSubmitted] = useState(false);

  function validate(nextForm = form) {
    const nextErrors = {};
    if (nextForm.name.trim().length < 5) nextErrors.name = 'Name should have at least 5 characters.';
    if (!nextForm.email.includes('@') || !nextForm.email.includes('.')) nextErrors.email = 'Email should contain @ and .';
    if (nextForm.password.length < 8) nextErrors.password = 'Password should have at least 8 characters.';
    setErrors(nextErrors);
    return Object.keys(nextErrors).length === 0;
  }

  function handleChange(event) {
    const nextForm = { ...form, [event.target.name]: event.target.value };
    setForm(nextForm);
    validate(nextForm);
  }

  function handleSubmit(event) {
    event.preventDefault();
    setSubmitted(validate());
  }

  return (
    <form className="card" onSubmit={handleSubmit} noValidate>
      <h2>Mail Register</h2>
      <label>Name<input name="name" value={form.name} onChange={handleChange} /></label>
      {errors.name && <p className="error">{errors.name}</p>}
      <label>Email<input name="email" value={form.email} onChange={handleChange} /></label>
      {errors.email && <p className="error">{errors.email}</p>}
      <label>Password<input name="password" type="password" value={form.password} onChange={handleChange} /></label>
      {errors.password && <p className="error">{errors.password}</p>}
      <button type="submit">Register</button>
      {submitted && <p>Registration completed.</p>}
    </form>
  );
}

export default function App() {
  return <main className="app-shell"><section className="panel"><h1>Mail Register App</h1><Register /></section></main>;
}
