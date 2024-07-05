package com.rnagaraju.springboot.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService=todoService;
	}

	@RequestMapping(value="list-todos")
//	@ResponseBody
	public String listAllTodos(ModelMap model) {
		List<Todo> todos=todoService.findByUsername("in28minutes");
		model.put("todos", todos);
		return "listTodos"; 
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		Todo newTodo=new Todo();
		newTodo.setDescription("Default Desc"); //One-way bind
		model.put("todo", newTodo);
		return "addTodo";
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
//	@ResponseBody
	public String addTodoPage(ModelMap model, Todo todo) {
		//Two-way bind from JSP
		String username=(String) model.get("name"); 
		todoService.addTodo(username, todo.getDescription(), LocalDate.now(), false);
		return "redirect:list-todos";
	}
} 
