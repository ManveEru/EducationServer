package ru.manveru.spring.educationserver.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.manveru.spring.educationserver.EmployeeRepository;
import ru.manveru.spring.educationserver.model.Employee;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    // Создать нового сотрудника
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    // Получить всех сотрудников
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    // Получить сотрудника по ID
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }
    
    // Обновить сотрудника
    public Employee updateEmployee(int id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        
        employee.setName(employeeDetails.getName());
        employee.setSurname(employeeDetails.getSurname());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setSalary(employeeDetails.getSalary());
        
        return employeeRepository.save(employee);
    }
    
    // Удалить сотрудника
    public void deleteEmployee(int id) {
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        
        employeeRepository.delete(employee);
    }
}
