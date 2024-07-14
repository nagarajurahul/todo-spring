package com.rnagaraju.springboot.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

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
	public String addTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "addTodo";
		}

		//Two-way bind from JSP for description and to do object basically
		String username=(String) model.get("name"); 
		todoService.addTodo(username, todo.getDescription(), LocalDate.now(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="delete-todo",method=RequestMethod.GET)
//	@ResponseBody
	public String deleteTodo() {
		return "redirect:list-todos";
	}
	
} 
