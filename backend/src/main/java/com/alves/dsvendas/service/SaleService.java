package com.alves.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alves.dsvendas.dto.SaleDTO;
import com.alves.dsvendas.dto.SaleSuccessDTO;
import com.alves.dsvendas.dto.SaleSumDTO;
import com.alves.dsvendas.entities.Sale;
import com.alves.dsvendas.repositories.SaleRepository;
import com.alves.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
    private SaleRepository saleRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
    
	@Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
    	sellerRepository.findAll();
    	
        Page<Sale> salePage = saleRepository.findAll(pageable);
        
        return salePage.map(sale -> new SaleDTO(sale));
    }
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return saleRepository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> sucessGroupedBySeller() {
		return saleRepository.sucessGroupedBySeller();
	}
}
