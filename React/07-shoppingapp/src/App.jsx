import React from 'react';

class Cart {
  constructor(itemname, price) {
    this.itemname = itemname;
    this.price = price;
  }
}

class OnlineShopping extends React.Component {
  constructor(props) {
    super(props);
    this.items = [
      new Cart('Laptop', 78000),
      new Cart('Headphones', 2800),
      new Cart('Keyboard', 1600),
      new Cart('Mouse', 900),
      new Cart('Monitor', 14500),
    ];
  }

  render() {
    return (
      <div className="grid">
        {this.items.map((item) => (
          <section className="card" key={item.itemname}>
            <h2>{item.itemname}</h2>
            <p>Rs. {item.price}</p>
          </section>
        ))}
      </div>
    );
  }
}

export default function App() {
  return (
    <main className="app-shell">
      <section className="panel">
        <h1>Online Shopping</h1>
        <OnlineShopping />
      </section>
    </main>
  );
}
