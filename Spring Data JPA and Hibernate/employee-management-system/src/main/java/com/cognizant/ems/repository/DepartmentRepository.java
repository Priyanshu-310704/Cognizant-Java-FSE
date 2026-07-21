package com.cognizant.ems.repository;

import com.cognizant.ems.dto.DepartmentEmployeeCountDto;
import com.cognizant.ems.entity.Department;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByExactName(String name);

    @Query("select new com.cognizant.ems.dto.DepartmentEmployeeCountDto(d.id, d.name, count(e)) from Department d left join d.employees e group by d.id, d.name")
    List<DepartmentEmployeeCountDto> fetchDepartmentEmployeeCounts();
}
