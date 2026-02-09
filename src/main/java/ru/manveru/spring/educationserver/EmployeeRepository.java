package ru.manveru.spring.educationserver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.manveru.spring.educationserver.model.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {
    
}
