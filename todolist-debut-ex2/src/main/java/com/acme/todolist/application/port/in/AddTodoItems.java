package com.acme.todolist.application.port.in;

import com.acme.todolist.domain.TodoItem;

public interface AddTodoItems {

	/**
	 * 
	 * @return créer un item
	 */
	void createTodoItem(TodoItem todoItem);

}
