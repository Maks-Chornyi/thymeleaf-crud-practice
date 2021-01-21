package com.makschornyi.thymeleafcrudpractice.service;

import com.makschornyi.thymeleafcrudpractice.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
