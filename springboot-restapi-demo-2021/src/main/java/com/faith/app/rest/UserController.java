package com.faith.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.dao.UserRepository;
import com.faith.app.dto.UserModel;
import com.faith.app.entity.User;
import com.faith.app.service.UserService;

@RestController
public class UserController {
	
	private UserService userService;
    private UserRepository userRepository;
    
    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    
    /*Create User*/
    @PostMapping("/api/users/create")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
    	
    	return userService.createUser(user);
    }
    
    //get all users
    @GetMapping("/api/users/all")
    public List<UserModel> getUsers(){
    	return userService.getUsers();
    }
    
    @GetMapping("/api/users/details/{id}")
    public UserModel getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
    
    @PutMapping("/api/users/update/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(user, id);
    }
    @DeleteMapping("/api/users/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
    

}
