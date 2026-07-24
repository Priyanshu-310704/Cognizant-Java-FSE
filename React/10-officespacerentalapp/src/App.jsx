const officeImage = new URL('./assets/office.svg', import.meta.url).href;

const offices = [
  { name: 'DBS', rent: 50000, address: 'Chennai' },
  { name: 'WeWork Galaxy', rent: 74000, address: 'Bengaluru' },
  { name: 'SmartWorks', rent: 61000, address: 'Hyderabad' },
];

export default function App() {
  return (
    <main className="app-shell">
      <section className="panel">
        <h1>Office Space Rental</h1>
        <img className="office-image" src={officeImage} alt="Office workspace" />
        <div className="grid">
          {offices.map((office) => (
            <section className="card" key={office.name}>
              <h2>{office.name}</h2>
              <p style={{ color: office.rent < 60000 ? 'red' : 'green', fontWeight: 700 }}>Rent: Rs. {office.rent}</p>
              <p>Address: {office.address}</p>
            </section>
          ))}
        </div>
      </section>
    </main>
  );
}
