package com.makschornyi.thymeleafcrudpractice.controller;

import com.makschornyi.thymeleafcrudpractice.model.Employee;
import com.makschornyi.thymeleafcrudpractice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

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

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String showFormForUpdate(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "redirect:/employee";
    }
}
