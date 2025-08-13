package com.example.crudmicroservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Company name is required")
    @Size(max = 255, message = "Company name must not exceed 255 characters")
    @Column(name = "name", nullable = false)
    private String name;
    
    @NotBlank(message = "NIP is required")
    @Size(max = 20, message = "NIP must not exceed 20 characters")
    @Column(name = "nip", nullable = false, unique = true)
    private String nip;
    
    @ElementCollection
    @CollectionTable(name = "company_employees", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "employee_name")
    private List<String> employees = new ArrayList<>();
    
    public Company() {}
    
    public Company(String name, String nip) {
        this.name = name;
        this.nip = nip;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getNip() {
        return nip;
    }
    
    public void setNip(String nip) {
        this.nip = nip;
    }
    
    public List<String> getEmployees() {
        return employees;
    }
    
    public void setEmployees(List<String> employees) {
        this.employees = employees;
    }
}