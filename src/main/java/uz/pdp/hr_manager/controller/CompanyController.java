package uz.pdp.hr_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.hr_manager.entity.Company;
import uz.pdp.hr_manager.payload.Result;
import uz.pdp.hr_manager.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping
    public List<Company> allList() {
        List<Company> companies = companyService.allCompanyList();
        return companies;
    }

    @GetMapping("/{id}")
    public Company getId(@PathVariable Integer id) {
        Company companyId = companyService.getCompanyId(id);
        return companyId;
    }

    @PostMapping
    public Result add(@RequestBody Company company) {
        Result result = companyService.addCompany(company);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody Company company) {
        Result result = companyService.editingCompany(id, company);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = companyService.deletedCompany(id);
        return result;
    }

}
