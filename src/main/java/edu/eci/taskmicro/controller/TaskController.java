package edu.eci.taskmicro.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.taskmicro.dto.TaskDto;
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
        return new ResponseEntity<List<UserDto>>(userService.fromEntityToDtos(allUsers), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> findById(@RequestParam(value = "name") String name) {
        User user = userService.findById(id);
        System.out.println("Que monda esta pasado");
        System.out.println("usuario buscado " + user.getName() + " id " + user.getId());
        return new ResponseEntity<UserDto>(userService.fromEntityToDto(user), HttpStatus.ACCEPTED);
    }

    @PostMapping()
    public ResponseEntity<TaskDto> create(@RequestParam(value="name") String name) {
        User user = userService.fromDtoToEntity(userDto);
        return new ResponseEntity<TaskDto>(userService.fromEntityToDto(userService.create(user)), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> update(@RequestBody UserDto user, @PathVariable String id) {
        User userC = userService.fromDtoToEntity(user);
        userService.fromEntityToDto(userService.update(userC, id));
        return new ResponseEntity<UserDto>(userService.fromEntityToDto(userService.update(userC, id)),
                HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        // TODO implement this method using UserService
        return null;
    }
}
