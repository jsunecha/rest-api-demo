package com.faith.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faith.app.dao.RoleRepository;
import com.faith.app.dao.UserRepository;
import com.faith.app.entity.Role;
import com.faith.app.entity.User;

@Service
public class RoleService {

	private RoleRepository roleRepository;
    private UserRepository userRepository;

    public RoleService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }
	
    
    /** Create a new role  */
    public ResponseEntity<Object> addRole(Role role)  {
    	
    	Role newRole = new Role();
    	newRole.setName(role.getName());
        newRole.setDescription(role.getDescription());
        
        List<Role> roleList = new ArrayList<>();
        roleList.add(newRole);
        
        for(int i=0; i< role.getUsers().size(); i++){
        	
        	User newUser = role.getUsers().get(i);
        	newUser.setRoles(roleList);
        	
        	User savedUser =userRepository.save(newUser);
        
        }
        return ResponseEntity.ok("Successfully created Role");
    	
    }
    
}
