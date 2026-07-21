package com.cognizant.ems.service;

import com.cognizant.ems.dto.EmployeeRequest;
import com.cognizant.ems.entity.Department;
import com.cognizant.ems.entity.Employee;
import com.cognizant.ems.projection.EmployeeNameView;
import com.cognizant.ems.repository.DepartmentRepository;
import com.cognizant.ems.repository.EmployeeRepository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional(readOnly = true)
    public List<Employee> findAll() { return employeeRepository.findAll(); }

    @Transactional(readOnly = true)
    public Employee get(Long id) { return employeeRepository.findById(id).orElseThrow(); }

    @Transactional
    public Employee create(EmployeeRequest request) {
        Employee employee = new Employee();
        apply(employee, request);
        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee update(Long id, EmployeeRequest request) {
        Employee employee = get(id);
        apply(employee, request);
        return employeeRepository.save(employee);
    }

    @Transactional
    public void delete(Long id) { employeeRepository.deleteById(id); }

    @Transactional(readOnly = true)
    public List<Employee> searchByName(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

    @Transactional(readOnly = true)
    public Page<Employee> activeEmployees(Pageable pageable) {
        return employeeRepository.findByActiveTrue(pageable);
    }

    @Transactional(readOnly = true)
    public List<EmployeeNameView> activeEmployeeNames() {
        return employeeRepository.findByActiveTrue();
    }

    private void apply(Employee employee, EmployeeRequest request) {
        Department department = departmentRepository.findById(request.departmentId()).orElseThrow();
        employee.setName(request.name());
        employee.setEmail(request.email());
        employee.setSalary(request.salary());
        employee.setActive(request.active());
        employee.setDepartment(department);
    }
}
