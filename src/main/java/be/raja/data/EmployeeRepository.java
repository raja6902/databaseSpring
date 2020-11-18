package be.raja.data;

import be.raja.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    boolean deleteEmployee(Employee employee);
    Optional<Employee> findEmployeeById(Long id);
    List<Employee> findAllEmployees();
}
