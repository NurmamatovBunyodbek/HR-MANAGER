package uz.pdp.hr_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hr_manager.entity.Company;

public interface CompanyRepo extends JpaRepository<Company,Integer> {


}
