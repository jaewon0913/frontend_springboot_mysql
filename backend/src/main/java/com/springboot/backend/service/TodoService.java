package com.springboot.backend.service;

import com.springboot.backend.model.Todo;
import com.springboot.backend.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    /**
     * Todo 작성
     */
    @Transactional
    public Long save(Todo todo){
        todoRepository.save(todo);

        return todo.getId();
    }

    /**
     * Todo 전체 조회
     */
    public List<Todo> findTodos(){
        return todoRepository.findAll();
    }

    /**
     * Todo 단건 조회
     */
    public Todo findOne(Long todoId){
        return todoRepository.findOne(todoId);
    }

    /**
     * Todo 완료 상태 수정
     */
    @Transactional
    public void updateTodoComplted(Long id, boolean completed) {
        Todo todo = todoRepository.findOne(id);

        todo.setCompleted(completed);
    }

    /**
     * Todo 삭제(DB 업데이트)
     */
    @Transactional
    public void updateTodoUseYn(Long id) {
        Todo todo = todoRepository.findOne(id);

        todo.setUseYn("N");
    }
}
