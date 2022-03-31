package com.example.cardealer.repositories;

import com.example.cardealer.models.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartSupplierRepository extends JpaRepository<Supplier, Long> {
}
