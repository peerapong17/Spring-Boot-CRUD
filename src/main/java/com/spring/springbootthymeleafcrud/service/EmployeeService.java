package com.spring.springbootthymeleafcrud.service;

import com.spring.springbootthymeleafcrud.model.Employee;
import com.spring.springbootthymeleafcrud.model.Category;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    List<Category> getAllCategories();
    Employee getEmployeeById(long id);
    void createEmployee(Employee employee);
    void updateEmployee(long id, Employee employee);
    void deleteEmployee(long id);
}
