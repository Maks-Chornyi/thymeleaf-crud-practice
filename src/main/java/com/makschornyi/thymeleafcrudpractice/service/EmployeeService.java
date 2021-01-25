package com.makschornyi.thymeleafcrudpractice.service;

import com.makschornyi.thymeleafcrudpractice.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    void saveEmployee(Employee employee);

    Employee findById(Long id);

    void deleteById(Long id);

    Page<Employee> findPaginated(int pageNum, int pageSize, String sortField, String direction);
}
