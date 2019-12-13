package com.crud.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crud.model.entities.Country;


@Repository("countryRepository")
public interface CountryRepository extends JpaRepository<Country, Integer> 
{
    @Query("select u from Country u order by u.pk asc")
	List<Country> findAllOrder();    
    
}