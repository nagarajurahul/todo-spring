package com.rnagaraju.springboot.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {

	@RequestMapping(value="list-todos")
	@ResponseBody
	public String listAllTodos() {
		return "listOfTodos";
	}
}
