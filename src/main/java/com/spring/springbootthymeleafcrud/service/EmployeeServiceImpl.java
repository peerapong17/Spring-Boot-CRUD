package com.spring.springbootthymeleafcrud.service;

import com.spring.springbootthymeleafcrud.model.Employee;
import com.spring.springbootthymeleafcrud.model.Category;

import com.spring.springbootthymeleafcrud.repository.EmployeeRepository;
import com.spring.springbootthymeleafcrud.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    
    @Autowired
    private CategoryRepository categoryRepository;
//    private EmployeeRepository employeeRepository;
//
//    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//        super();
//        this.employeeRepository = employeeRepository;
//    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employeeExist = this.employeeRepository.findById(id);
        Employee employee = null;

        if(employeeExist.isPresent()){
            employee = employeeExist.get();
        } else {
            throw new RuntimeException(" Employee not found with given id :: " + id);
        }
        return employee;
    }

    @Override
    public void updateEmployee(long id, Employee employee) {
        Employee existingEmployee = this.employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException(" Employee not found with given id :: " + id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(existingEmployee);
    }

    @Override
    public void createEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        this.employeeRepository.deleteById(id);
    }
}
