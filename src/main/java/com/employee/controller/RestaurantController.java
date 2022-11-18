package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exception.ResourceNotFoundException;
import com.employee.model.Restaurant;
import com.employee.repository.RestaurantRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RestaurantController {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	//Get All restaurant
	@GetMapping("/restaurant")
	public List<Restaurant> getAllRestaurant(){
		return restaurantRepository.findAll();
	}
	//create  Restaurant
	@PostMapping("/restaurant")
	public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}
	
	// Get by id
	@GetMapping("/restaurant/{id}")
	public ResponseEntity<Restaurant>  getRestaurantById( @PathVariable long id) {
		Restaurant restaurant=restaurantRepository.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Restairant Not exist by this +" +id));
		return ResponseEntity.ok(restaurant);
		
	}
	
	//update restaurant
	@PutMapping("/restaurant/{id}")
	public ResponseEntity<Restaurant> updateRestaurant( @PathVariable long id,@RequestBody Restaurant restaurantdetails){
		Restaurant restaurant=restaurantRepository.findById(id).orElseThrow(()->
			new ResourceNotFoundException("Restaurant not exist with this id:"+ id));	
		restaurant.setRestaurantName(restaurantdetails.getRestaurantName());
		restaurant.setPhoneNumber(restaurantdetails.getPhoneNumber());
		restaurant.setCompletAdress(restaurantdetails.getCompletAdress());
		restaurant.setEmail(restaurantdetails.getEmail());
		restaurant.setOwnerName(restaurantdetails.getOwnerName());
		restaurant.setTinNumber(restaurantdetails.getTinNumber());
		restaurant.setLatitude(restaurantdetails.getLatitude());
		restaurant.setLongitude(restaurantdetails.getLongitude());
		restaurant.setUserid(restaurantdetails.getUserid());
		Restaurant updateResturant=restaurantRepository.save(restaurant);
		return ResponseEntity.ok(updateResturant);
		
		
	}
}
