package com.cognizant.springlearn.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    @NotNull(message = "Employee id is required")
    private Integer id;

    @NotBlank(message = "Employee name is required")
    @Size(min = 1, max = 30, message = "Employee name should be between 1 and 30 characters")
    private String name;

    @NotNull(message = "Employee salary is required")
    @Min(value = 0, message = "Employee salary should be zero or above")
    private Double salary;

    @NotNull(message = "Permanent flag is required")
    private Boolean permanent;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;

    @Valid
    @NotNull(message = "Department is required")
    private Department department;

    @Valid
    private List<Skill> skillList = new ArrayList<>();

    public Integer getId() { return id; }
    public String getName() { return name; }
    public Double getSalary() { return salary; }
    public Boolean getPermanent() { return permanent; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public Department getDepartment() { return department; }
    public List<Skill> getSkillList() { return skillList; }
    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSalary(Double salary) { this.salary = salary; }
    public void setPermanent(Boolean permanent) { this.permanent = permanent; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setDepartment(Department department) { this.department = department; }
    public void setSkillList(List<Skill> skillList) { this.skillList = skillList; }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + ", permanent=" + permanent + "}";
    }
}
