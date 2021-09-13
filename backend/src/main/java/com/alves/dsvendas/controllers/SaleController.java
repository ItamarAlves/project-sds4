package com.alves.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alves.dsvendas.dto.SaleDTO;
import com.alves.dsvendas.dto.SaleSuccessDTO;
import com.alves.dsvendas.dto.SaleSumDTO;
import com.alves.dsvendas.service.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		Page<SaleDTO> saleList = saleService.findAll(pageable);
		
		return ResponseEntity.ok(saleList);
	}
	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
		List<SaleSumDTO> saleSumList = saleService.amountGroupedBySeller();
		return ResponseEntity.ok(saleSumList);
	}
	
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> sucessGroupedBySeller() {
		List<SaleSuccessDTO> saleSuccessList = saleService.sucessGroupedBySeller();
		return ResponseEntity.ok(saleSuccessList);
	}
}
