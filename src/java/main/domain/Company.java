package domain;

import java.util.List;
import java.util.Set;

public class Company {
    private long id;
    private String name;
    private String nip;
    private List<CompanyAddress> addresses;
    private Set<CompanyEmployee> employees;
    
    public Company() {}
    
    public Company(long id, String name, String nip, List<CompanyAddress> addresses, Set<CompanyEmployee> employees) {
        this.id = id;
        this.name = name;
        this.nip = nip;
        this.addresses = addresses;
        this.employees = employees;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
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
    
    public List<CompanyAddress> getAddresses() {
        return addresses;
    }
    
    public void setAddresses(List<CompanyAddress> addresses) {
        this.addresses = addresses;
    }
    
    public Set<CompanyEmployee> getEmployees() {
        return employees;
    }
    
    public void setEmployees(Set<CompanyEmployee> employees) {
        this.employees = employees;
    }
}