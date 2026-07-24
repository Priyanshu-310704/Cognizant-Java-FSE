import { useState } from 'react';
import EmployeesList from './EmployeesList.jsx';
import ThemeContext from './ThemeContext.js';

const employees = [
  { id: 1, name: 'Asha', role: 'Developer' },
  { id: 2, name: 'Rahul', role: 'Tester' },
  { id: 3, name: 'Meera', role: 'Analyst' },
];

export default function App() {
  const [theme, setTheme] = useState('light');
  return (
    <ThemeContext.Provider value={theme}>
      <main className={`app-shell ${theme}`}>
        <section className="panel">
          <h1>Employee Management</h1>
          <div className="actions">
            <button onClick={() => setTheme(theme === 'light' ? 'dark' : 'light')}>Toggle Theme</button>
          </div>
          <EmployeesList employees={employees} />
        </section>
      </main>
    </ThemeContext.Provider>
  );
}
