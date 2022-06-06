package com.springboot.backend.repository;

import com.springboot.backend.model.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TodoRepository {

    private final EntityManager em;

    // 작성
    public void save(Todo todo){
        em.persist(todo);
    }

    // 단건 조회
    public Todo findOne(Long id){
        return em.find(Todo.class, id);
    }

    // 전체 조회
    public List<Todo> findAll(boolean orderState){

        List<Todo> todoList = null;
        if(orderState){
            todoList = em.createQuery(
                    "select t from Todo t" +
                            " where t.useYn = 'Y'" +
                            " order by t.writeDate DESC ", Todo.class)
                    .getResultList();
        } else {
            todoList = em.createQuery(
                    "select t from Todo t" +
                            " where t.useYn = 'Y'" +
                            " order by t.writeDate ASC ", Todo.class)
                    .getResultList();
        }

        return todoList;
    }

    // 전체 업데이트
    @Modifying
    @Query(value = "UPDATE Todo t set t.useYn = 'N' WHERE t.useYn = 'Y'", nativeQuery = true)
    public void updateTodoAllClear() {
    }
}
