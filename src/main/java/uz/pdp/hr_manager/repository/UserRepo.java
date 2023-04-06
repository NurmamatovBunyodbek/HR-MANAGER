package uz.pdp.hr_manager.repository;

import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hr_manager.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {

       boolean existsByEmail(String email);

        Optional<User>findByEmailAndEmailCode( String email, String emailCode);

        Optional<User> findByEmail(String email);

}
