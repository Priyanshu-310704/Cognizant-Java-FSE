import styles from './CohortDetails.module.css';

export default function CohortDetails({ cohort }) {
  const titleColor = cohort.status === 'ongoing' ? 'green' : 'blue';
  return (
    <section className={styles.box}>
      <h3 style={{ color: titleColor }}>{cohort.code}</h3>
      <dl>
        <dt>Name</dt>
        <dd>{cohort.name}</dd>
        <dt>Status</dt>
        <dd>{cohort.status}</dd>
        <dt>Started</dt>
        <dd>{cohort.startDate}</dd>
        <dt>Trainer</dt>
        <dd>{cohort.trainer}</dd>
      </dl>
    </section>
  );
}
