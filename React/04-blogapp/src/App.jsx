import React from 'react';

class Post {
  constructor(userId, id, title, body) {
    this.userId = userId;
    this.id = id;
    this.title = title;
    this.body = body;
  }
}

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [
        new Post(1, 1, 'Local starter post', 'This appears until the API response arrives.'),
      ],
      error: null,
    };
  }

  async loadPosts() {
    const response = await fetch('https://jsonplaceholder.typicode.com/posts');
    const data = await response.json();
    this.setState({
      posts: data.slice(0, 8).map((post) => new Post(post.userId, post.id, post.title, post.body)),
    });
  }

  componentDidMount() {
    this.loadPosts().catch((error) => this.setState({ error: error.message }));
  }

  componentDidCatch(error) {
    alert(`Component error: ${error.message}`);
  }

  render() {
    return (
      <div>
        {this.state.error && <p className="error">{this.state.error}</p>}
        <div className="grid">
          {this.state.posts.map((post) => (
            <article className="card" key={post.id}>
              <h2>{post.title}</h2>
              <p>{post.body}</p>
            </article>
          ))}
        </div>
      </div>
    );
  }
}

export default function App() {
  return (
    <main className="app-shell">
      <section className="panel">
        <h1>Blog App</h1>
        <Posts />
      </section>
    </main>
  );
}
