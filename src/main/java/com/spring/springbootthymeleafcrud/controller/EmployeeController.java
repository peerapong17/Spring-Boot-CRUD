package com.spring.springbootthymeleafcrud.controller;

import com.spring.springbootthymeleafcrud.model.Employee;
import com.spring.springbootthymeleafcrud.model.Category;
import com.spring.springbootthymeleafcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    private EmployeeService employeeService;
//
//    public EmployeeController(EmployeeService employeeService) {
//        super();
//        this.employeeService = employeeService;
//    }

    @GetMapping("/")
    public String index(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        
        return "index";
    }

    @GetMapping("/{id}")
    public String getEmployee(Model model, @PathVariable(value = "id") long employee_id) {
        Employee employee = employeeService.getEmployeeById(employee_id);
        List<Category> categories = employeeService.getAllCategories();

        model.addAttribute("employee", employee);
        model.addAttribute("categories", categories);

        return "update";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Employee employee = new Employee();
        List<Category> categories = employeeService.getAllCategories();

        model.addAttribute("employee", employee);
        model.addAttribute("categories", categories);
        
        return "create";
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(Model model, @PathVariable(value = "id") long id, @ModelAttribute("employee") Employee employee) {
        employeeService.updateEmployee(id, employee);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String createEmployee(@PathVariable(value = "id") long employee_id) {
        employeeService.deleteEmployee(employee_id);
        return "redirect:/";
    }


}
