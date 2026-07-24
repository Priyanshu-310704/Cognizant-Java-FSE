import axios from 'axios';

class GitClient {
  static async getRepositories(userName) {
    const response = await axios.get(`https://api.github.com/users/${userName}/repos`);
    return response.data.map((repository) => repository.name);
  }
}

export default GitClient;
