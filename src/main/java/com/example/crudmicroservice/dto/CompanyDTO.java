package com.example.crudmicroservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class CompanyDTO {
    
    private Long id;
    
    @NotBlank(message = "Company name is required")
    @Size(max = 255, message = "Company name must not exceed 255 characters")
    private String name;
    
    @NotBlank(message = "NIP is required")
    @Size(max = 20, message = "NIP must not exceed 20 characters")
    private String nip;
    
    private List<String> employees = new ArrayList<>();
    
    public CompanyDTO() {}
    
    public CompanyDTO(Long id, String name, String nip, List<String> employees) {
        this.id = id;
        this.name = name;
        this.nip = nip;
        this.employees = employees != null ? employees : new ArrayList<>();
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