package com.cognizant.ems.repository;

import com.cognizant.ems.entity.Employee;
import com.cognizant.ems.projection.EmployeeNameView;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameContainingIgnoreCase(String name);

    List<Employee> findByDepartmentNameIgnoreCase(String departmentName);

    List<Employee> findBySalaryGreaterThan(double salary);

    List<Employee> findActiveEmployees();

    Optional<Employee> findByEmailAddress(String email);

    Page<Employee> findByActiveTrue(Pageable pageable);

    @Query("select e from Employee e where lower(e.email) = lower(:email)")
    Optional<Employee> findByEmailUsingQuery(@Param("email") String email);

    List<EmployeeNameView> findByActiveTrue();
}
