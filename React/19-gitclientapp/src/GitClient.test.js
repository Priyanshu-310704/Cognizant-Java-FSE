import axios from 'axios';
import { describe, expect, test, vi } from 'vitest';
import GitClient from './GitClient.js';

vi.mock('axios');

describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    axios.get.mockResolvedValue({
      data: [
        { name: 'react-training' },
        { name: 'spring-boot-labs' },
      ],
    });

    const repositories = await GitClient.getRepositories('techiesyed');

    expect(axios.get).toHaveBeenCalledWith('https://api.github.com/users/techiesyed/repos');
    expect(repositories).toEqual(['react-training', 'spring-boot-labs']);
  });
});
