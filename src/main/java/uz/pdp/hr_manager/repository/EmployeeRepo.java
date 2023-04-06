package uz.pdp.hr_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hr_manager.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
