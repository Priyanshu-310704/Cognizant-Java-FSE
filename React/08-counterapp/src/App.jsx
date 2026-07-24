import React from 'react';

class CountPeople extends React.Component {
  constructor(props) {
    super(props);
    this.state = { entrycount: 0, exitcount: 0 };
  }

  UpdateEntry = () => this.setState((state) => ({ entrycount: state.entrycount + 1 }));
  UpdateExit = () => this.setState((state) => ({ exitcount: state.exitcount + 1 }));

  render() {
    return (
      <section className="card">
        <h2>Mall Counter</h2>
        <p>People entered: {this.state.entrycount}</p>
        <p>People exited: {this.state.exitcount}</p>
        <div className="actions">
          <button onClick={this.UpdateEntry}>Login</button>
          <button className="secondary" onClick={this.UpdateExit}>Exit</button>
        </div>
      </section>
    );
  }
}

export default function App() {
  return <main className="app-shell"><section className="panel"><CountPeople /></section></main>;
}
