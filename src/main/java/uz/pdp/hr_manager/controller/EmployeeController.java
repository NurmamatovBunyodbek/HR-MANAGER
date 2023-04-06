package uz.pdp.hr_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.hr_manager.entity.Employee;
import uz.pdp.hr_manager.payload.Result;
import uz.pdp.hr_manager.service.EmployeeService;

import javax.management.relation.RelationSupport;
import java.util.List;

@RestController
@RequestMapping("/{employee}")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> all() {
        List<Employee> list = employeeService.allEmployeeList();
        return list;
    }

    @PostMapping
    public Result add(@RequestBody Employee employee) {
        Result result = employeeService.addEmployee(employee);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody Employee employee) {
        Result result = employeeService.editingEmployee(id, employee);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = employeeService.deletedEmployee(id);
        return result;
    }
}
