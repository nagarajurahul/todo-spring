package com.rnagaraju.springboot.todo.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@RequestMapping("/")
//	@ResponseBody
	public String welcome(ModelMap model) {
		model.put("name","Rahul");
		return "welcome";
	}
}
