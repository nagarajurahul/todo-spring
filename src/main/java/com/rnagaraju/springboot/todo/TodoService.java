package com.rnagaraju.springboot.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount=0;
	
	static {
		todos.add(new Todo(++todosCount, "rahul","Learn AWS", 
							LocalDate.now().plusYears(1), false ));
		todos.add(new Todo(++todosCount, "rahul","Learn DevOps", 
				LocalDate.now().plusYears(2), false ));
		todos.add(new Todo(++todosCount, "rahul","Learn Full Stack Development", 
				LocalDate.now().plusYears(3), false ));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate dueDate, boolean done) {
		Todo newTodo= (new Todo(++todosCount, username,description,dueDate,done));
		todos.add(newTodo);
	}
	
	public void deleteTodoById(int id) {
		//todo.getId() == id
		// todo -> todo.getId() == id
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	
	public Todo findTodoById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(Todo updateTodo) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == updateTodo.getId();
		todos.removeIf(predicate);
		todos.add(updateTodo);
		
	}
}
