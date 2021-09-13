package com.alves.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alves.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{

}
