package com.in28minutes.springbootproject.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ToDoService {

	private static List<ToDo> todos = new ArrayList<>();

	private static int todosCount = 0;

	static {
		todos.add(new ToDo(++todosCount, "Tamiz", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new ToDo(++todosCount, "Tamiz", "Learn DevOps", LocalDate.now().plusYears(3), true));
		todos.add(new ToDo(++todosCount, "Tamiz", "Learn FullStack", LocalDate.now().plusYears(2), false));
	}

	public List<ToDo> findByUserName(String UserName) {
		

		Predicate<? super ToDo> Predicate = ToDo -> ToDo.getUserName().equalsIgnoreCase(UserName);

		return todos.stream().filter(Predicate).toList();

	}

	public void addToDo(String userName, String description, LocalDate targetDate, boolean status) {

		ToDo todo = new ToDo(++todosCount, userName, description, targetDate, status);
		todos.add(todo);
	}

	public void deleteByID(int id) {

		Predicate<? super ToDo> Predicate = ToDo -> ToDo.getId() == id;
		todos.removeIf(Predicate);
	}

	public ToDo findByID(int id) {

		Predicate<? super ToDo> Predicate = ToDo -> ToDo.getId() == id;
		ToDo matchingtodo = todos.stream().filter(Predicate).findFirst().get();
		return matchingtodo;
	}

	public void updateToDo(@Valid ToDo toDo) {
		deleteByID(toDo.getId());
		todos.add(toDo);

	}
}
