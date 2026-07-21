package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Department;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {
    private static final List<Department> DEPARTMENT_LIST = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public DepartmentDao() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml")) {
            DEPARTMENT_LIST.clear();
            DEPARTMENT_LIST.addAll((List<Department>) context.getBean("departmentList"));
        }
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
