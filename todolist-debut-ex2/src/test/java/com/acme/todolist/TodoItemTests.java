package com.acme.todolist;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import org.junit.jupiter.api.Test;

import com.acme.todolist.domain.TodoItem;

public class TodoItemTests {

	static final String LATE = "[LATE!] ";
	
	@Test
	public void finalContent_todoIsLate() {
		LocalDate date = LocalDate.parse("2000-12-31");
		Instant late = date.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		TodoItem todo = new TodoItem("1", late, "this todo is late");
		System.out.println(todo.finalContent());

		assertTrue(todo.finalContent().contains(LATE));
	}

	@Test
	public void finalContent_todoIsNotLate() {
		Instant notLate = Instant.now();
		TodoItem todo = new TodoItem("2", notLate, "this todo is not late");
		System.out.println(todo.finalContent());

		assertTrue(!todo.finalContent().contains(LATE));
	}
}
