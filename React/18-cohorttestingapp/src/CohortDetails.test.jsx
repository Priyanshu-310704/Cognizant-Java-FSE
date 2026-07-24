import { render, screen } from '@testing-library/react';
import { describe, expect, test } from 'vitest';
import CohortDetails from './CohortDetails.jsx';
import CohortData from './Cohort.js';

describe('Cohort Details Component', () => {
  test('should create the component', () => {
    render(<CohortDetails cohort={CohortData[0]} />);
    expect(screen.getByText('Java Full Stack Engineer')).toBeInTheDocument();
  });

  test('should initialize the props', () => {
    render(<CohortDetails cohort={CohortData[1]} />);
    expect(screen.getByText(CohortData[1].name)).toBeInTheDocument();
  });

  test('should display cohort code in h3', () => {
    render(<CohortDetails cohort={CohortData[0]} />);
    expect(screen.getByRole('heading', { level: 3 })).toHaveTextContent(CohortData[0].code);
  });

  test('should always render same html', () => {
    const { container } = render(<CohortDetails cohort={CohortData[0]} />);
    expect(container.firstChild).toMatchSnapshot();
  });
});
