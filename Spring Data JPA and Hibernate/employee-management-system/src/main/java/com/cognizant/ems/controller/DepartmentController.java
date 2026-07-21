package com.cognizant.ems.controller;

import com.cognizant.ems.dto.DepartmentEmployeeCountDto;
import com.cognizant.ems.entity.Department;
import com.cognizant.ems.service.DepartmentService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> all() { return departmentService.findAll(); }

    @GetMapping("/{id}")
    public Department get(@PathVariable Long id) { return departmentService.get(id); }

    @PostMapping
    public Department create(@RequestBody Department department) { return departmentService.save(department); }

    @PutMapping("/{id}")
    public Department update(@PathVariable Long id, @RequestBody Department department) {
        department.setId(id);
        return departmentService.save(department);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { departmentService.delete(id); }

    @GetMapping("/projection/counts")
    public List<DepartmentEmployeeCountDto> counts() { return departmentService.projectionCounts(); }
}
