package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
    private static final List<Employee> EMPLOYEE_LIST = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public EmployeeDao() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml")) {
            EMPLOYEE_LIST.clear();
            EMPLOYEE_LIST.addAll((List<Employee>) context.getBean("employeeList"));
        }
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    public void updateEmployee(Employee employee) {
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId().equals(employee.getId())) {
                EMPLOYEE_LIST.set(i, employee);
                return;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public void deleteEmployee(int id) {
        boolean removed = EMPLOYEE_LIST.removeIf(employee -> employee.getId().equals(id));
        if (!removed) {
            throw new EmployeeNotFoundException();
        }
    }
}
