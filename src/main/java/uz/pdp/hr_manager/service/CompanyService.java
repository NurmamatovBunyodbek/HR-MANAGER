package uz.pdp.hr_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.hr_manager.entity.Company;
import uz.pdp.hr_manager.payload.Result;
import uz.pdp.hr_manager.repository.CompanyRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepo companyRepo;

    public List<Company> allCompanyList(){
        List<Company> companyList = companyRepo.findAll();
        return companyList;
    }

    public  Company getCompanyId(Integer id){
        Optional<Company> optionalCompany = companyRepo.findById(id);
        return  optionalCompany.get();
    }

    public Result addCompany(Company company){
        Company company1 = new Company();
        company1.setName(company.getName());
        company1.setAddManager(company.getAddManager());
        companyRepo.save(company1);
        return new Result("Added",true);
    }

    public  Result editingCompany(Integer id  , Company company){
        Optional<Company> optional = companyRepo.findById(id);
        if (optional.isPresent()){
            Company company1 = optional.get();
            company1.setName(company.getName());
            company1.setAddManager(company.getAddManager());
            return new Result("Company editing ",true);
        }
        return new Result("Company not found",false);
    }

    public Result deletedCompany(Integer id){
        companyRepo.deleteById(id);
        return new Result("Company deleted",true);
    }
}
