package com.cognizant.ems.controller;

import com.cognizant.ems.dto.EmployeeRequest;
import com.cognizant.ems.entity.Employee;
import com.cognizant.ems.projection.EmployeeNameView;
import com.cognizant.ems.service.EmployeeService;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> all() { return employeeService.findAll(); }

    @GetMapping("/{id}")
    public Employee get(@PathVariable Long id) { return employeeService.get(id); }

    @PostMapping
    public Employee create(@RequestBody EmployeeRequest request) { return employeeService.create(request); }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody EmployeeRequest request) {
        return employeeService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { employeeService.delete(id); }

    @GetMapping("/search")
    public List<Employee> search(@RequestParam String name) { return employeeService.searchByName(name); }

    @GetMapping("/page")
    public Page<Employee> page(@PageableDefault(size = 5, sort = "name") Pageable pageable) {
        return employeeService.activeEmployees(pageable);
    }

    @GetMapping("/projection/names")
    public List<EmployeeNameView> names() { return employeeService.activeEmployeeNames(); }
}
