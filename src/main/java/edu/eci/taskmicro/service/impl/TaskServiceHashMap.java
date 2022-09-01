package edu.eci.taskmicro.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import edu.eci.taskmicro.dto.TaskDto;
import edu.eci.taskmicro.entities.Status;


import edu.eci.taskmicro.entities.Task;
import edu.eci.taskmicro.service.TaskService;

public class TaskServiceHashMap implements TaskService {

    private HashMap<String,Task> tasks;
    private final AtomicLong counter = new AtomicLong();
    public TaskServiceHashMap(){
        tasks = new HashMap<>();
        tasks.put("21", new Task("Votar","ECI","Andrés","Ayer","Antier",Status.TODO));
        tasks.put("22", new Task("Estudiar", "ECI", "Andrés", "Ayer", "Antier", Status.TODO));
    }
    @Override
    public Task create(Task task) {
        return tasks.put(Long.toString(counter.incrementAndGet()), task);
    }

    @Override
    public Task findById(String id) {
        return tasks.get(id);
    }

    @Override
    public List<Task> getAll() {
        return  tasks.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(String id) {
        boolean flag;
        if(tasks.containsKey(id)){
            tasks.remove(id);
            flag = true;
        }else{flag = false;}
        return flag;
    }

    @Override
    public Task update(Task task, String id) {
        return tasks.put(id, task);
    }
    @Override
    public TaskDto fromEntityToDto(Task user) {
        TaskDto userDto = new TaskDto(user.getName(), user.getDescription(), user.getAssignedTo(),user.getDueDate(),
                user.getCreatedAt(),user.getStatus());
        return userDto;
    }
    @Override
    public List<TaskDto> fromEntityToDtos(List<Task> user) {
        return user.stream().map(x -> fromEntityToDto(x)).collect(Collectors.toList()); 
    }
    @Override
    public Task fromDtoToEntity(TaskDto userDto) {
         Task user = new Task(userDto.getId(), userDto.getName(), userDto.getEmail(), userDto.getLastName(),
                userDto.getCreatedAt());
        return user;
    }
    
}
