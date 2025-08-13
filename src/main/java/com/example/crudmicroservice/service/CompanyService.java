package com.example.crudmicroservice.service;

import com.example.crudmicroservice.dto.CompanyDTO;
import com.example.crudmicroservice.entity.Company;
import com.example.crudmicroservice.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;
    
    public List<CompanyDTO> getAllCompanies() {
        return companyRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public Optional<CompanyDTO> getCompanyById(Long id) {
        return companyRepository.findById(id)
                .map(this::convertToDTO);
    }
    
    public Optional<CompanyDTO> getCompanyByNip(String nip) {
        return companyRepository.findByNip(nip)
                .map(this::convertToDTO);
    }
    
    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        if (companyRepository.existsByNip(companyDTO.getNip())) {
            throw new RuntimeException("Company with NIP " + companyDTO.getNip() + " already exists");
        }
        
        Company company = convertToEntity(companyDTO);
        Company savedCompany = companyRepository.save(company);
        return convertToDTO(savedCompany);
    }
    
    public Optional<CompanyDTO> updateCompany(Long id, CompanyDTO companyDTO) {
        return companyRepository.findById(id)
                .map(existingCompany -> {
                    // Check if NIP is being changed and if it already exists
                    if (!existingCompany.getNip().equals(companyDTO.getNip()) && 
                        companyRepository.existsByNip(companyDTO.getNip())) {
                        throw new RuntimeException("Company with NIP " + companyDTO.getNip() + " already exists");
                    }
                    
                    existingCompany.setName(companyDTO.getName());
                    existingCompany.setNip(companyDTO.getNip());
                    existingCompany.setEmployees(companyDTO.getEmployees());
                    
                    Company updatedCompany = companyRepository.save(existingCompany);
                    return convertToDTO(updatedCompany);
                });
    }
    
    public boolean deleteCompany(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    private CompanyDTO convertToDTO(Company company) {
        return new CompanyDTO(
                company.getId(),
                company.getName(),
                company.getNip(),
                company.getEmployees()
        );
    }
    
    private Company convertToEntity(CompanyDTO companyDTO) {
        Company company = new Company(companyDTO.getName(), companyDTO.getNip());
        company.setEmployees(companyDTO.getEmployees());
        return company;
    }
}