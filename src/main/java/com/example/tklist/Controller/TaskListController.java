package com.example.tklist.Controller;
import com.example.tklist.DTO.TaskListDTO;
import com.example.tklist.entities.Tasks.TaskList;
import com.example.tklist.services.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "/lists")
public class TaskListController {

    @Autowired
    private TaskListService service;

    @GetMapping
    public List<TaskListDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskListDTO> getTaskListById(@PathVariable Long id) {
        TaskListDTO taskListDTO = service.findById(id);
        if (taskListDTO != null) {
            return ResponseEntity.ok(taskListDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
