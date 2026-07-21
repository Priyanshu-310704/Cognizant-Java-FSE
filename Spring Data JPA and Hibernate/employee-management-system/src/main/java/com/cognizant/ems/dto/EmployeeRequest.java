package com.cognizant.ems.dto;

public record EmployeeRequest(String name, String email, double salary, boolean active, Long departmentId) {
}
