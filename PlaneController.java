package com.example.demo;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaneController {
	private PlaneService service;
	
	@Autowired
	public PlaneController(PlaneService service) {
		super();
		this.service = service;
	}

	@GetMapping("/hello")
	public String greeting () {
	return "Hello, world!";
}
@PostMapping("/createPlane")
public ResponseEntity<Plane> makePlane(@RequestBody Plane plane) {
	System.out.println("Body: " + plane);
	return new ResponseEntity<Plane>(this.service.makePlane(plane), HttpStatus.CREATED);
}

@RequestMapping(method = RequestMethod.GET, path = "/getAll")
public List<Plane> getAllBiscuits() {
	return this.service.getAllPlanes();
}

@GetMapping("/get/{id}")
public ResponseEntity<Plane> getById(@PathVariable int id) {
	System.out.println("ID: " + id);
	return new ResponseEntity<Plane>(this.service.getById(id), HttpStatus.OK);
}
	
@PatchMapping("/update/{id}")
public Plane updatePlane(@PathVariable int id, @PathParam("name") String name, @PathParam("size") Integer size,
		@PathParam("cost") Double cost) {
	System.out.println("ID: " + id);
	System.out.println("NAME: " + name);
	System.out.println("SIZE: " + size);
	System.out.println("COST: " + cost);
	
	return this.service.updatePlane(id, name, size, cost);
}
@DeleteMapping("/remove/{id}")
public void delete(@PathVariable int id) {
	System.out.println("ID " + id);
	this.service.delete(id);
}






}
