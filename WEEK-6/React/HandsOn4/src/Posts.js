// src/Posts.js
import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false
    };
  }

  // Load real English posts
  loadPosts = () => {
    const englishPosts = [
      {
        id: 1,
        title: "Welcome to My Blog",
        body: "This is the first post about React lifecycle methods and how they work."
      },
      {
        id: 2,
        title: "Using componentDidMount()",
        body: "componentDidMount() is used to run code after the component is rendered."
      },
      {
        id: 3,
        title: "Understanding componentDidCatch()",
        body: "componentDidCatch() is used to handle rendering errors in a component."
      },
      {
        id: 4,
        title: "Creating Reusable Components",
        body: "Splitting your UI into reusable components helps keep your code clean and modular."
      },
      {
        id: 5,
        title: "React Class vs Functional Components",
        body: "Class components give you more control over state and lifecycle, while functional ones are simpler and use hooks."
      }
    ];

    this.setState({ posts: englishPosts });
  };

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert("An error occurred: " + error);
  }

  render() {
    if (this.state.hasError) {
      return <h2>Something went wrong while loading posts.</h2>;
    }

    return (
      <div>
        <h1>Posts</h1>
        {this.state.posts.map(post => (
          <Post key={post.id} title={post.title} body={post.body} />
        ))}
      </div>
    );
  }
}

export default Posts;
