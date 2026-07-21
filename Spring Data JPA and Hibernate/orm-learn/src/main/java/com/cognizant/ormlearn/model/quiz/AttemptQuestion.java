package com.cognizant.ormlearn.model.quiz;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "attempt_question")
public class AttemptQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "attempt_id")
    private Attempt attempt;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToMany(mappedBy = "attemptQuestion", fetch = FetchType.EAGER)
    private Set<AttemptOption> attemptOptions = new LinkedHashSet<>();

    public Integer getId() { return id; }
    public Attempt getAttempt() { return attempt; }
    public Question getQuestion() { return question; }
    public Set<AttemptOption> getAttemptOptions() { return attemptOptions; }
    public void setId(Integer id) { this.id = id; }
    public void setAttempt(Attempt attempt) { this.attempt = attempt; }
    public void setQuestion(Question question) { this.question = question; }
    public void setAttemptOptions(Set<AttemptOption> attemptOptions) { this.attemptOptions = attemptOptions; }
}
