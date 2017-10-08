package com.emirates.todoapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emirates.todoapp.models.TodoEntity;
import com.emirates.todoapp.repository.TodoCrudRepository;

@Service
public class CrudService {
	
	@Autowired
	TodoCrudRepository todoCrudRepo;
	
	
	public List<TodoEntity> fetchAll(){
		return (List<TodoEntity>) todoCrudRepo.findAll();
	}
	
	public TodoEntity get(long id){		
		return todoCrudRepo.findOne(id);
	}
	
	public TodoEntity add(TodoEntity todoItem){		
		return todoCrudRepo.save(todoItem);
	}
	
	public void delete( long id){
		todoCrudRepo.delete(id);
	}

}
