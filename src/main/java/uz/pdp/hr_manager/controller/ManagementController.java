package uz.pdp.hr_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.hr_manager.entity.Management;
import uz.pdp.hr_manager.payload.Result;
import uz.pdp.hr_manager.service.ManagementService;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagementController {

    @Autowired
    ManagementService managementService;

    @GetMapping
    public List<Management> all() {
        List<Management> list = managementService.allManagement();
        return list;
    }

    @GetMapping("/{id}")
    public Management getId(@PathVariable Integer id) {
        Management idManager = managementService.getIdManager(id);
        return idManager;
    }

    @PostMapping
    public Result add(@RequestBody Management management) {
        Result result = managementService.addSalary(management);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = managementService.deletedManagement(id);
        return result;
    }
}
