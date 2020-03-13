package com.acme.todolist.application.service;

import javax.inject.Inject;

import com.acme.todolist.application.port.out.UpdateTodoItem;
import com.acme.todolist.domain.TodoItem;

public class AddTodoItemsService {
	private UpdateTodoItem updateTodoItem;
	
	@Inject
	public AddTodoItemsService(UpdateTodoItem updateTodoItem) {
		this.updateTodoItem = updateTodoItem;
	}
	
	public void createTodoItem(TodoItem todoItem) {
		this.updateTodoItem.storeNewTodoItem(todoItem);;
	}
}

