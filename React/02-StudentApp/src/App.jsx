import React from 'react';

class Home extends React.Component {
  render() {
    return <section className="card"><h2>Home</h2><p>Welcome to the Home page of Student Management Portal</p></section>;
  }
}

class About extends React.Component {
  render() {
    return <section className="card"><h2>About</h2><p>Welcome to the About page of Student Management Portal</p></section>;
  }
}

class Contact extends React.Component {
  render() {
    return <section className="card"><h2>Contact</h2><p>Welcome to the Contact page of Student Management Portal</p></section>;
  }
}

export default class App extends React.Component {
  render() {
    return (
      <main className="app-shell">
        <section className="panel">
          <h1>Student Management Portal</h1>
          <div className="grid">
            <Home />
            <About />
            <Contact />
          </div>
        </section>
      </main>
    );
  }
}
