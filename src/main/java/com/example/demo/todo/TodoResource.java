package com.example.demo.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
 

@RestController 
@CrossOrigin("*")
//@RequestMapping("/users/")
public class TodoResource {
	
	@Autowired
	private TodoHardCodedService todoService;

	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable("username") String username){
		
		return todoService.findAll();
	}
		
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable("username")String username,@PathVariable("id") long id) 
	{
		System.err.println("Username = "+username+"\n ID = "+id);
		Todo todo = todoService.deleteById(id);
		if(todo!=null)
		{
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodoById(@PathVariable("username") String username,@PathVariable("id") long id) {
		
		return todoService.findById(id);
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public  ResponseEntity<Todo> updateTodo(@PathVariable("username") String username
											,@PathVariable("id") long id
											,@RequestBody Todo todo)
	{
		Todo todoUpdated = todoService.saveTodo(todo);
		return new ResponseEntity<Todo>(todoUpdated ,HttpStatus.OK);
	}
	
	@PostMapping("/users/{username}/todos")
	public  ResponseEntity<Todo> saveTodo(@PathVariable("username") String username
											,@RequestBody Todo todo)
	{
		
		Todo createdTodo = todoService.saveTodo(todo);
		System.err.println("created ToDo = "+createdTodo);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		return  ResponseEntity.created(uri).build();
	}
} 


