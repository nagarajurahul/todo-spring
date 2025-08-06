package com.rnagaraju.springboot.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class TodoControllerJpa {
	
//	TodoService todoService;
	TodoRepository todoRepository;
	
//	public TodoControllerJpa(TodoService todoService) {
	public TodoControllerJpa(TodoRepository todoRepository) {
		super();
//		this.todoService=todoService;
		this.todoRepository=todoRepository;
	}

	@RequestMapping(value="list-todos")
//	@ResponseBody
	public String listAllTodos(ModelMap model) {
		String username = getLoggedinUsername();
		List<Todo> todos=todoRepository.findByUsername(username);
		model.put("todos", todos);
		return "listTodos"; 
	}

	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	@RequestMapping("/todo")
//	@ResponseBody
	public String welcome(ModelMap model) {
		model.put("name",getLoggedinUsername());
		return "welcome";
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
		String username=getLoggedinUsername();
		todoRepository.save(todo);
//		todoService.addTodo(username, todo.getDescription(), todo.getDueDate(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="delete-todo",method=RequestMethod.GET)
//	@ResponseBody
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);
//		todoService.deleteTodoById(id);
		return "redirect:list-todos";
		
	}
	
	@RequestMapping(value="show-todo",method=RequestMethod.GET)
	@ResponseBody
	public String showTodo(@RequestParam int id) {
		return todoRepository.findById(id).toString();
//		return todoService.findTodoById(id).toString();
	}
	
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
//	@ResponseBody
	public String showUpdateTodoPage(ModelMap model,@RequestParam int id) {
//		Todo todo=todoService.findTodoById(id);
		Todo todo=todoRepository.findById(id).get();
		model.put("todo", todo);
		System.out.println(model.getAttribute("todo"));
		return "updateTodo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
//	@ResponseBody
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result, @RequestParam int id) {
		// @Valid Todo todo, BindingResult result -  very importannt, without this it was null in model.todo
//		System.out.print("Inside update to-do");
//		System.out.println(model.getAttribute("todo"));
		
		String username = getLoggedinUsername(); 
		todo.setUsername(username);
		
		todoRepository.save(todo);
//		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
} 
