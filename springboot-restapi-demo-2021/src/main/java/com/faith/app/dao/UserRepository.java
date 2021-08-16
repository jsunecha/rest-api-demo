package com.faith.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.faith.app.entity.User;

@Repository		//SPRING DATA JPA
public interface UserRepository extends JpaRepository<User, Long> {
	// customize methods
	Optional <User> findByEmail(String email);
	
	//Query 
	@Query(value = "select * from t_user2", nativeQuery = true)
	List<User> findAllByUserId();
	
	// @Query(value = "delete  from t_user_roles where users_id= :user_id", nativeQuery = true)
	// void deleteRelation(@Param("user_id") Long user_id);

}
