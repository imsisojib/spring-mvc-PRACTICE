package spring_jdbc_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import spring_jdbc_crud.model.User;
import spring_jdbc_crud.services.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/add-user")
	public String addUserPage(Model model) {
		model.addAttribute("message","ADD NEW USER");
		return "add-user";
	}
	
	
	@PostMapping("/add-user")
	public String addUser(Model model, @ModelAttribute(name="userObj")User userObj) {
		userService.addUser(userObj);
		model.addAttribute("message","User Added Successfully");
		return "add-user";
	}
	
}
