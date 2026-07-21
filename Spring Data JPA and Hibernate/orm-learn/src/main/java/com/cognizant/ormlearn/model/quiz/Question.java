package com.cognizant.ormlearn.model.quiz;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_text", length = 500)
    private String questionText;

    private double score;

    @OneToMany(mappedBy = "question")
    private Set<QuizOption> options = new LinkedHashSet<>();

    public Integer getId() { return id; }
    public String getQuestionText() { return questionText; }
    public double getScore() { return score; }
    public Set<QuizOption> getOptions() { return options; }
    public void setId(Integer id) { this.id = id; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }
    public void setScore(double score) { this.score = score; }
    public void setOptions(Set<QuizOption> options) { this.options = options; }
}
