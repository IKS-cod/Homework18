package Homework18.controller.controller;

import Homework18.controller.service.EmployeeService;
import Homework18.controller.exception.EmployeeAlreadyAddedException;
import Homework18.controller.exception.EmployeeNotFoundException;
import Homework18.controller.exception.EmployeeStorageIsFullException;
import Homework18.controller.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam String firstName,
                                 @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName,lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam String firstName,
                               @RequestParam String lastName) {
        return employeeService.findEmployee(firstName,lastName);
    }
}
