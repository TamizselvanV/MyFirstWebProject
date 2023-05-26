package com.in28minutes.springbootproject.myfirstwebapp.todo;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("userName")
public class ToDoController {

	private ToDoService todoService;

	public ToDoController(ToDoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todo")
	public String listAllToDO(ModelMap model) {

		String strUserName = getLoggedinUsername(model);
		List<ToDo> todoList = todoService.findByUserName(strUserName);
		model.addAttribute("todos", todoList);
		return "listAllToDo";
	}

	private String getLoggedinUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewToDoPage(ModelMap model) {
		String strUserName= (String) model.getAttribute("userName");		
		ToDo todo = new ToDo(10, strUserName, "", LocalDate.now().plusMonths(5), false);
		model.put("toDo", todo);
		return "toDo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewToDo(ModelMap model, @Valid ToDo toDo, BindingResult result) {

		if (result.hasErrors()) {
			return "toDo";
		}
				
		String userName = (String) model.get("userName");
		todoService.addToDo(userName, toDo.getDescription(), toDo.getTargetDate(), false);
		return "redirect:list-todo";
	}

	@RequestMapping("delete-todo")
	public String deleteToDo(@RequestParam int id) {
		todoService.deleteByID(id);
		return "redirect:list-todo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateToDoPage(@RequestParam int id, ModelMap model) {

		ToDo todo = todoService.findByID(id);
		model.addAttribute("toDo", todo);
		return "toDo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateToDo(ModelMap model, @Valid ToDo toDo, BindingResult result) {

		if (result.hasErrors()) {
			return "toDo";
		}
		String userName = getLoggedinUsername(model);
		toDo.setUserName(userName);
		todoService.updateToDo(toDo);
		return "redirect:list-todo";
	}
}
