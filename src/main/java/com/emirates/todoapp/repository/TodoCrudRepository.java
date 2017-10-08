package com.emirates.todoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.emirates.todoapp.models.TodoEntity;

public interface TodoCrudRepository extends CrudRepository<TodoEntity, Long> {

}
