package com.cognizant.ormlearn.model.quiz;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "attempt_option")
public class AttemptOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "attempt_question_id")
    private AttemptQuestion attemptQuestion;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private QuizOption option;

    @Column(name = "selected_answer")
    private boolean selectedAnswer;

    public Integer getId() { return id; }
    public AttemptQuestion getAttemptQuestion() { return attemptQuestion; }
    public QuizOption getOption() { return option; }
    public boolean isSelectedAnswer() { return selectedAnswer; }
    public void setId(Integer id) { this.id = id; }
    public void setAttemptQuestion(AttemptQuestion attemptQuestion) { this.attemptQuestion = attemptQuestion; }
    public void setOption(QuizOption option) { this.option = option; }
    public void setSelectedAnswer(boolean selectedAnswer) { this.selectedAnswer = selectedAnswer; }
}
