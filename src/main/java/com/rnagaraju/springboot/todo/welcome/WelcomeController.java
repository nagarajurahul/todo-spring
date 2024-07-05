package com.rnagaraju.springboot.todo.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@RequestMapping("todo")
	@ResponseBody
	public String welcome() {
		return "Welcome to To-Do";
	}
}
