package be.raja.service;

import be.raja.data.EmployeeRepository;
import be.raja.model.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceimpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceimpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        return false;
    }

    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Employee> findAllEmployees() {
        return null;
    }
}
