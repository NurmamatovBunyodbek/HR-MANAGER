package uz.pdp.hr_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.hr_manager.entity.NewTask;
import uz.pdp.hr_manager.payload.Result;
import uz.pdp.hr_manager.service.NewTaskService;

import java.util.List;

@RestController
@RequestMapping("/task")
public class NewTaskController {

    @Autowired
    NewTaskService newTaskService;

    @GetMapping
    public List<NewTask> list() {
        List<NewTask> tasks = newTaskService.allTaskList();
        return tasks;
    }

    @PostMapping
    public Result add(@RequestBody NewTask newTask) {
        Result result = newTaskService.addNewTask(newTask);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody NewTask newTask) {
        Result result = newTaskService.editingNewTask(id, newTask);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = newTaskService.deletedTask(id);
        return result;
    }


}
