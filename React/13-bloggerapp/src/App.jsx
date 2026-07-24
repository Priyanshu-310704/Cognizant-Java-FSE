const books = ['React Learning', 'Mastering JavaScript', 'Clean Code'];
const blogs = [
  { title: 'React Router', author: 'Cognizant Academy' },
  { title: 'State and Props', author: 'React Team' },
];
const courses = ['Angular', 'React', 'Spring Boot'];

function BookDetails() {
  return <section className="card"><h2>Book Details</h2>{books.map((book) => <p key={book}>{book}</p>)}</section>;
}

function BlogDetails() {
  return <section className="card"><h2>Blog Details</h2>{blogs.map((blog) => <p key={blog.title}>{blog.title} by {blog.author}</p>)}</section>;
}

function CourseDetails() {
  return <section className="card"><h2>Course Details</h2>{courses.map((course) => <p key={course}>{course}</p>)}</section>;
}

export default function App() {
  const showBooks = true;
  const showBlogs = true;
  const selectedView = 'courses';
  let elementVariable = <CourseDetails />;

  return (
    <main className="app-shell">
      <section className="panel">
        <h1>Blogger App</h1>
        <div className="grid">
          {showBooks && <BookDetails />}
          {showBlogs ? <BlogDetails /> : null}
          {selectedView === 'courses' ? elementVariable : <p>No course selected</p>}
        </div>
      </section>
    </main>
  );
}
