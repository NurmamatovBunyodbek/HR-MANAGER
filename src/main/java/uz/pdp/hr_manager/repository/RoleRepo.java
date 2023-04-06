package uz.pdp.hr_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hr_manager.entity.Role;
import uz.pdp.hr_manager.entity.enums.RoleName;

public interface RoleRepo extends JpaRepository<Role,Integer> {

    Role findByName(RoleName name);
}
