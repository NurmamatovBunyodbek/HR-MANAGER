package uz.pdp.hr_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.hr_manager.entity.Management;
import uz.pdp.hr_manager.payload.Result;
import uz.pdp.hr_manager.repository.ManagementRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ManagementService {

    @Autowired
    ManagementRepo managementRepo;

    public List<Management> allManagement() {
        List<Management> managements = managementRepo.findAll();
        return managements;
    }

    public Management getIdManager(Integer id) {
        Optional<Management> optionalManagement = managementRepo.findById(id);
        return optionalManagement.get();
    }

    public Result addSalary(Management management) {
        Management management1 = new Management();
        management1.setSalary(management.getSalary());
        management1.setInformation(management.getInformation());
        managementRepo.save(management1);
        return new Result("Added", true);
    }

    public Result deletedManagement(Integer id) {
        managementRepo.deleteById(id);
        return new Result("deleted ", true);
    }


}
