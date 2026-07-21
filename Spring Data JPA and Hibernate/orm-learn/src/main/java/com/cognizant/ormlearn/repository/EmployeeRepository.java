package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select distinct e from Employee e left join fetch e.department left join fetch e.skillList where e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    @Query("select avg(e.salary) from Employee e where e.department.id = :id")
    double getAverageSalary(@Param("id") int id);

    @Query(value = "select * from employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}
