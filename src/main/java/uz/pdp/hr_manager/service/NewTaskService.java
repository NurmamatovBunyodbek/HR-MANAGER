package uz.pdp.hr_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.hr_manager.entity.NewTask;
import uz.pdp.hr_manager.payload.Result;
import uz.pdp.hr_manager.repository.NewTaskRepo;

import java.util.List;
import java.util.Optional;

@Service
public class NewTaskService {

    @Autowired
    NewTaskRepo newTaskRepo;

    public List<NewTask> allTaskList() {
        List<NewTask> taskList = newTaskRepo.findAll();
        return taskList;
    }

    public Result addNewTask(NewTask newTask) {
        NewTask newTask1 = new NewTask();
        newTask1.setEmployee_id(newTask.getEmployee_id());
        newTask1.setName(newTask.getName());
        newTask1.setComment(newTask.getComment());
        newTask1.setFinalTask(newTask.getFinalTask());
        newTaskRepo.save(newTask1);
        return new Result("Added Task", true);
    }

    public Result editingNewTask(Integer id, NewTask newTask) {
        Optional<NewTask> optionalNewTask = newTaskRepo.findById(id);
        if (optionalNewTask.isPresent()) {
            NewTask newTask1 = optionalNewTask.get();
            newTask1.setEmployee_id(newTask.getEmployee_id());
            newTask1.setName(newTask.getName());
            newTask1.setComment(newTask.getComment());
            newTask1.setFinalTask(newTask.getFinalTask());
            newTaskRepo.save(newTask1);
            return new Result("Editing task", true);
        }
        return new Result("Task not found", false);
    }

    public Result deletedTask(Integer id) {
        newTaskRepo.deleteById(id);
        return new Result("Task deleted", true);
    }

}
