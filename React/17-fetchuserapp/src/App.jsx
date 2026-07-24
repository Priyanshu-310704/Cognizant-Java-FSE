import React from 'react';

class Getuser extends React.Component {
  constructor(props) {
    super(props);
    this.state = { title: '', firstName: '', image: '', loading: true, error: '' };
  }

  async componentDidMount() {
    try {
      const response = await fetch('https://api.randomuser.me/');
      const data = await response.json();
      const user = data.results[0];
      this.setState({
        title: user.name.title,
        firstName: user.name.first,
        image: user.picture.large,
        loading: false,
      });
    } catch (error) {
      this.setState({ error: error.message, loading: false });
    }
  }

  render() {
    if (this.state.loading) return <section className="card"><p>Loading user...</p></section>;
    if (this.state.error) return <section className="card"><p className="error">{this.state.error}</p></section>;
    return (
      <section className="card user-card">
        <img src={this.state.image} alt={this.state.firstName} />
        <h2>{this.state.title} {this.state.firstName}</h2>
      </section>
    );
  }
}

export default function App() {
  return <main className="app-shell"><section className="panel"><h1>Fetch User App</h1><Getuser /></section></main>;
}
