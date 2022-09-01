package edu.eci.taskmicro.service;

import java.util.List;

import edu.eci.taskmicro.dto.TaskDto;
import edu.eci.taskmicro.entities.Task;

public interface TaskService {
    Task create(Task task);

    Task findById(String id);

    List<Task> getAll();

    boolean deleteById(String id);

    Task update(Task task, String id);

    TaskDto fromEntityToDto(Task user);

    List<TaskDto> fromEntityToDtos(List<Task> user);

    Task fromDtoToEntity(TaskDto userDto);
}