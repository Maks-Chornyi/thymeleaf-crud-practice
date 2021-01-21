package com.makschornyi.thymeleafcrudpractice.service.impl;

import com.makschornyi.thymeleafcrudpractice.model.Employee;
import com.makschornyi.thymeleafcrudpractice.repository.EmployeeRepository;
import com.makschornyi.thymeleafcrudpractice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }
}
