package com.makschornyi.thymeleafcrudpractice.controller;

import com.makschornyi.thymeleafcrudpractice.model.Employee;
import com.makschornyi.thymeleafcrudpractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String viewEmployeePage(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employee";
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Employee> getAll() {
        return employeeService.findAll();
    }
}
