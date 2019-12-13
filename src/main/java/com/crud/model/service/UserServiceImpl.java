package com.crud.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.entities.User;
import com.crud.model.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService
{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) 
    {
        this.userRepository = userRepository;
    }

    @Override
    public User findByEmailAndPassword(String email, String password)
    {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User saveUser(User user) 
    {        
        return userRepository.save(user);
    }

	@Override
	public List<User> findAll() 
	{
		
		List<User> lista = userRepository.findAllOrder();
		lista.forEach(x -> {
			System.out.println(x.getName());
		});
		List<User> lista2 = userRepository.findAll();
		lista2.forEach(x -> {
			System.out.println(x.getName());
		});
		
		return userRepository.findAll();
	}

	@Override
	public User findOne(Integer id) 
	{
		return userRepository.findById(id).get();
	}

	@Override
	public void remove(Integer id) 
	{
		userRepository.deleteById(id);
	}

	@Override
	public List<User> findAllOrder() 
	{
		List<User> lista = userRepository.findAllOrder();
		lista.forEach(x -> {
			System.out.println(x.getName());
		});
		List<User> lista2 = userRepository.findAll();
		lista2.forEach(x -> {
			System.out.println(x.getName());
		});
		return userRepository.findAllOrder();
	}

}