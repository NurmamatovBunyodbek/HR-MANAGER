package uz.pdp.hr_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hr_manager.entity.NewTask;

public interface NewTaskRepo extends JpaRepository<NewTask,Integer> {

}
