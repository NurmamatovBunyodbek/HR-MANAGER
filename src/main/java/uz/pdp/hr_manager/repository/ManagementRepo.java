package uz.pdp.hr_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hr_manager.entity.Management;

public interface ManagementRepo extends JpaRepository<Management,Integer> {

}
