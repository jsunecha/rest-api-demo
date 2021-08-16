package com.faith.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.faith.app.entity.Role;

@Repository 	// Spring DATA JPA
public interface RoleRepository extends JpaRepository<Role, Long> {

	
}
