package com.example.ToDoApplication.controllers;

import com.example.ToDoApplication.models.Task;
import com.example.ToDoApplication.services.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
@Slf4j
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@RequestBody Task task) {
       log.info("Criando nova tarefa: [{}]", task);
        return taskService.create(task);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> index() {
        log.info("Listando todas as tarefas.");
        return taskService.index();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> show(@PathVariable (value = "id") Long id) {

        log.info("Exibindo tarefa pelo id [{}].",id);
        return taskService.show(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> show(@PathVariable (value = "id") Long id, @RequestBody Task task) {

        log.info("Atualizando tarefa pelo id [{}], com as novas informações [{}].", id, task);
        return taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> delete(@PathVariable (value = "id") Long id) {
        log.info("Excluíndo tarefa pelo id [{}].",id);
        return taskService.delete(id);
    }



}
