package Homework18.controller;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
