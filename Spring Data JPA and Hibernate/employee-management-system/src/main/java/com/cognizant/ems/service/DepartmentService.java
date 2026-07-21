package com.cognizant.ems.service;

import com.cognizant.ems.dto.DepartmentEmployeeCountDto;
import com.cognizant.ems.entity.Department;
import com.cognizant.ems.repository.DepartmentRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional(readOnly = true)
    public List<Department> findAll() { return departmentRepository.findAll(); }

    @Transactional(readOnly = true)
    public Department get(Long id) { return departmentRepository.findById(id).orElseThrow(); }

    @Transactional
    public Department save(Department department) { return departmentRepository.save(department); }

    @Transactional
    public void delete(Long id) { departmentRepository.deleteById(id); }

    @Transactional(readOnly = true)
    public List<DepartmentEmployeeCountDto> projectionCounts() {
        return departmentRepository.fetchDepartmentEmployeeCounts();
    }
}
