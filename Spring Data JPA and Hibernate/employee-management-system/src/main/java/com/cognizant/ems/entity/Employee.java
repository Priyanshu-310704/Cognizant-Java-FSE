package com.cognizant.ems.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "employees")
@NamedQueries({
        @NamedQuery(name = "Employee.findActiveEmployees", query = "select e from Employee e where e.active = true"),
        @NamedQuery(name = "Employee.findByEmailAddress", query = "select e from Employee e where e.email = ?1")
})
@DynamicUpdate
public class Employee extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private double salary;
    private boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @BatchSize(size = 10)
    @JsonIgnore
    private Department department;

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public double getSalary() { return salary; }
    public boolean isActive() { return active; }
    public Department getDepartment() { return department; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setActive(boolean active) { this.active = active; }
    public void setDepartment(Department department) { this.department = department; }
}
