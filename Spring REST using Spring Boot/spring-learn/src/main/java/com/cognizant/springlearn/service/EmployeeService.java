package com.cognizant.springlearn.service;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.model.Employee;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Transactional
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }
}
