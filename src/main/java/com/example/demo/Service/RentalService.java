package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Rental;
import com.example.demo.Mapper.RentalMapper;

@Service
public class RentalService {

	@Autowired
	RentalMapper rentalMapper;
	
	
	public List<Rental> findRentalBook(int rental_key_id) {
		return rentalMapper.findRentalBook(rental_key_id);
	}

}
