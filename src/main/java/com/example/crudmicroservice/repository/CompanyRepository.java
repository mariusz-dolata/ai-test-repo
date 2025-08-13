package com.example.crudmicroservice.repository;

import com.example.crudmicroservice.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    
    Optional<Company> findByNip(String nip);
    
    boolean existsByNip(String nip);
    
    @Query("SELECT c FROM Company c WHERE c.name LIKE %:name%")
    Optional<Company> findByNameContaining(@Param("name") String name);
}