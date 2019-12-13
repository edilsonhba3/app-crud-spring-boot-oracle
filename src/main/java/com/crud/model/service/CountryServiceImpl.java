package com.crud.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.entities.Country;
import com.crud.model.repository.CountryRepository;

@Service("countryService")
public class CountryServiceImpl implements CountryService
{
	@Autowired
    private CountryRepository countryRepository;

	@Override
	public List<Country> findAllOrder() 
	{
		return countryRepository.findAllOrder();
	}

}