package Homework18.controller;

import Homework18.controller.Employee;
import Homework18.controller.EmployeeAlreadyAddedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int MAXPERSON = 3;
    List<Employee> employees = new ArrayList<>(MAXPERSON);

    public void removeEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        } else {
            employees.remove(employee);
        }
    }

    public void findEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        }
    }

    public String getEmployee() {
        return employees.toString();
    }

    public void addEmployee(Employee employee) {
        if (employees.size() >= MAXPERSON) {
            throw new EmployeeStorageIsFullException("Список переполнен");
        } else if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть в списке");
        } else {
            employees.add(employee);
        }

    }

}
