package com.springboot.backend.controller;

import com.springboot.backend.address.Todo;
import com.springboot.backend.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos/save")
    public String createJsonTodo(@RequestBody @Valid TodoForm form, BindingResult bindingResult){
        log.info("Post : Todo Save");
        log.info("TodoForm : " + form);

        return validation(form, bindingResult);
    }

    @GetMapping("/todos")
    public List<Todo> list(){
        log.info("Get : Todos List");

        return todoService.findTodos();
    }

    private String validation(@Valid @RequestBody TodoForm form, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "todo error";
        }

        Todo todo = new Todo();
        todo.setItem(form.getItem());
        todo.setCompleted(form.isCompleted());
        todo.setDate(form.getDate());
        todo.setTime(form.getTime());
        todo.setWriteDate(LocalDateTime.now());
        todo.setUpdateDate(LocalDateTime.now());

        todoService.save(todo);

        return "ok";
    }
}
