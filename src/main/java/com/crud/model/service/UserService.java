package com.crud.model.service;

import java.util.List;

import com.crud.model.entities.User;

public interface UserService 
{ 
    public User findByEmailAndPassword(String email, String password);

    public User saveUser(User user);

    public List<User> findAll();
    
    public User findOne(Integer id);
    
    public void remove(Integer id);

	public List<User> findAllOrder();
    
}