package com.acme.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import com.acme.todolist.adapters.rest_api.TodoListController;
import com.acme.todolist.application.service.AddTodoItemsService;
import com.acme.todolist.application.service.GetTodoItemsService;

@WebMvcTest(TodoListController.class)
public class TodoListControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AddTodoItemsService addTodoItem;
	@MockBean
	private GetTodoItemsService getTodoItem;
	
	@Test
	public void controllerShouldGetItem() throws Exception {
		when(getTodoItem.getAllTodoItems()).thenReturn(Collections.emptyList());
		
		this.mockMvc.perform(get("/todos")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("[]")));
	}

}
