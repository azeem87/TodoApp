package com.emirates.todoapp.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.todoapp.models.TodoEntity;
import com.emirates.todoapp.services.CrudService;


@RestController
@RequestMapping(value="/todos")
public class TodoCrudController {
	@Autowired CrudService crudService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<TodoEntity> fetchAll(){
		return crudService.fetchAll();
	}
	
	@RequestMapping("/{id}")
	public TodoEntity get(@PathVariable long id){		
		return crudService.get(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public TodoEntity insert(@RequestBody TodoEntity todoItem){		
		return crudService.add(todoItem);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public List<TodoEntity> delete(@PathVariable long id){
		
		if(crudService.get(id)!=null){
			crudService.delete(id);
		}
		return crudService.fetchAll();
	}
	
	
	
}
