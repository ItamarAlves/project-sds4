package com.alves.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alves.dsvendas.dto.SellerDTO;
import com.alves.dsvendas.entities.Seller;
import com.alves.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public List<SellerDTO> findAll() {
		List<Seller> sellerList = sellerRepository.findAll();
		
		return sellerList.parallelStream()
				.map(seller -> new SellerDTO(seller))
				.collect(Collectors.toList());  
	}
}
