package Homework18.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getEmployee() {
        return employeeService.getEmployee();
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (firstName == null || lastName == null) {
            return  "Параметр(ы) не задан(ы)";
        }
        try {
            employeeService.addEmployee(employee);
        }catch (EmployeeAlreadyAddedException|EmployeeStorageIsFullException e){
            return e.getMessage();
        }
        return "Сотрудник добавлен";
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (firstName == null || lastName == null) {
            return  "Параметр(ы) не задан(ы)";
        }
        try {
            employeeService.removeEmployee(employee);
        }catch (EmployeeNotFoundException e){
            return e.getMessage();
        }
        return "Сотрудник удален";
    }

    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam(required = false) String firstName,
                               @RequestParam(required = false) String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (firstName == null || lastName == null) {
            return  "Параметр(ы) не задан(ы)";
        }
        try {
            employeeService.findEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
        return "Сотрудник найден";
    }
}
