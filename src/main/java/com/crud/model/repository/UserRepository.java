package com.crud.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crud.model.entities.User;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> 
{
    User findByEmailAndPassword(String email, String password);

    @Query("select u from User u order by u.pk asc")
	List<User> findAllOrder();    
    
}