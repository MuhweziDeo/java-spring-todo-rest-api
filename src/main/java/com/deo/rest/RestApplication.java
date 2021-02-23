package com.deo.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

class PostBody {
	public String name;
}

@SpringBootApplication
@RestController
public class RestApplication {
	ArrayList<Todo> todos = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	@GetMapping("")
	public String hello(){
		return "hello word";
	}

	@GetMapping("/todos")
	public ArrayList<Todo> getTodos() {
		return todos;
	}
	
	@PostMapping("/todos")
	public ArrayList<Todo> addTodo(@NonNull @RequestBody PostBody body){
		Todo todo = new Todo(body.name);
		todo.id = todos.size() + 1;
		todos.add(todo);
		return todos;
	}

	@GetMapping("/todos/{id}")
	public Todo getTodo(@PathVariable String id) {

		for (Todo t : todos) {
			if (String.valueOf(t.id).equals(id)) {
				return t;
			}
		}
		return null;
	}

	@PutMapping("/todos/{id}/complete")
	public Todo updateTodo(@PathVariable String id) {
		for (Todo t : todos) {
			if (String.valueOf(t.id).equals(id)) {
				t.completed = true;
				return t;
			}
		}
		return null;
	}

}
