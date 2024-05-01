package Homework18.controller.service;

import Homework18.controller.exception.EmployeeAlreadyAddedException;
import Homework18.controller.exception.EmployeeNotFoundException;
import Homework18.controller.exception.EmployeeStorageIsFullException;
import Homework18.controller.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private final int maxEmployee = 3;
    List<Employee> employees = new ArrayList<>();

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public List<Employee> findAll() {

        return Collections.unmodifiableList(employees);
    }

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (employees.size() >= maxEmployee) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }
}
