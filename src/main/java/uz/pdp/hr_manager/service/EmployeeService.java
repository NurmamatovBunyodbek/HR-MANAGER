package uz.pdp.hr_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.hr_manager.entity.Employee;
import uz.pdp.hr_manager.payload.Result;
import uz.pdp.hr_manager.repository.EmployeeRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> allEmployeeList() {
        List<Employee> all = employeeRepo.findAll();
        return all;
    }

    public Result addEmployee(Employee employee) {
        Employee employee1 = new Employee();
        employee1.setUsername(employee.getUsername());
        employee1.setTurniket_id(employee.getTurniket_id());
        employeeRepo.save(employee1);
        return new Result("Save", true);
    }

    public Result editingEmployee(Integer id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee1 = optionalEmployee.get();
            employee1.setUsername(employee.getUsername());
            employee1.setTurniket_id(employee.getTurniket_id());
            employeeRepo.save(employee1);
            return new Result("Editing", true);
        }
        return new Result("Employee not found", false);
    }

    public Result deletedEmployee(Integer id) {
        employeeRepo.deleteById(id);
        return new Result("Deleted", true);
    }

}
