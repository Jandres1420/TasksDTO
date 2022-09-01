package edu.eci.taskmicro.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.taskmicro.dto.TaskDto;
import edu.eci.taskmicro.entities.Status;
import edu.eci.taskmicro.entities.Task;
import edu.eci.taskmicro.service.TaskService;

@RestController
public class TaskController {
    private final AtomicLong counter = new AtomicLong();
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAll() {
        List<Task> allTasks = taskService.getAll();
        return new ResponseEntity<List<TaskDto>>(taskService.fromEntityToDtos(allTasks),HttpStatus.ACCEPTED);
    }

    @GetMapping("/findId")
    public ResponseEntity<TaskDto> findById(@RequestParam(value = "id") String id) {
        Task task = taskService.findById(id);
        return new ResponseEntity<TaskDto>(taskService.fromEntityToDto(task), HttpStatus.ACCEPTED);
    }

    @PostMapping()
    public ResponseEntity<TaskDto> create(@RequestParam(value="name") String name,@RequestParam(value="description") String description,
            @RequestParam(value = "assignedTo") String assignedTo, @RequestParam(value = "dueDate") String dueDate, @RequestParam(value = "createdAt") String createdAt,
            @RequestParam(value = "status") String status) {
        if(status.equals("TODO")){
            Task task = new Task(name, description, assignedTo, dueDate, createdAt, Status.TODO);
            return new ResponseEntity<TaskDto>(taskService.fromEntityToDto(taskService.create(task)),
                    HttpStatus.ACCEPTED);
        }else if (status.equals("DONE")){
            Task task = new Task(name, description, assignedTo, dueDate, createdAt, Status.DONE);
            return new ResponseEntity<TaskDto>(taskService.fromEntityToDto(taskService.create(task)),
                    HttpStatus.ACCEPTED);
        } else if (status.equals("REVIEW")) {
            Task task = new Task(name, description, assignedTo, dueDate, createdAt, Status.REVIEW);
            return new ResponseEntity<TaskDto>(taskService.fromEntityToDto(taskService.create(task)),
                    HttpStatus.ACCEPTED);
        } else{
            Task task = new Task(name, description, assignedTo, dueDate, createdAt, Status.DOING);
            return new ResponseEntity<TaskDto>(taskService.fromEntityToDto(taskService.create(task)),
                    HttpStatus.ACCEPTED);
        }    
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> update(@RequestBody TaskDto user, @PathVariable String id) {
        Task userC = taskService.fromDtoToEntity(user);
        taskService.fromEntityToDto(taskService.update(userC, id));
        return new ResponseEntity<TaskDto>(taskService.fromEntityToDto(taskService.update(userC, id)),
                HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/Delete}")
    public boolean delete(@RequestParam(value = "id") String id) {
        return taskService.deleteById(id);
    }
}
