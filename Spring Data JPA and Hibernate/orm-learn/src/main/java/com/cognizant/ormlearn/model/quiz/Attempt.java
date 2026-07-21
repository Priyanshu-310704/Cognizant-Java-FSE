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
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "attempt")
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate attemptedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "attempt", fetch = FetchType.EAGER)
    private Set<AttemptQuestion> attemptQuestions = new LinkedHashSet<>();

    public Integer getId() { return id; }
    public LocalDate getAttemptedDate() { return attemptedDate; }
    public User getUser() { return user; }
    public Set<AttemptQuestion> getAttemptQuestions() { return attemptQuestions; }
    public void setId(Integer id) { this.id = id; }
    public void setAttemptedDate(LocalDate attemptedDate) { this.attemptedDate = attemptedDate; }
    public void setUser(User user) { this.user = user; }
    public void setAttemptQuestions(Set<AttemptQuestion> attemptQuestions) { this.attemptQuestions = attemptQuestions; }
}
