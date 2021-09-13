package com.alves.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alves.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
