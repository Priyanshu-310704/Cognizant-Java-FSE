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
@Table(name = "quiz_option")
public class QuizOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "option_text")
    private String optionText;

    @Column(name = "correct_answer")
    private boolean correctAnswer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Integer getId() { return id; }
    public String getOptionText() { return optionText; }
    public boolean isCorrectAnswer() { return correctAnswer; }
    public Question getQuestion() { return question; }
    public void setId(Integer id) { this.id = id; }
    public void setOptionText(String optionText) { this.optionText = optionText; }
    public void setCorrectAnswer(boolean correctAnswer) { this.correctAnswer = correctAnswer; }
    public void setQuestion(Question question) { this.question = question; }
}
