package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Company;

public interface CompanyService {

	
	public Company saveCompany(Company comp);
	
	public List<Company> getAllCompanies();
	
	public Company getCompanybyId(Long id);
}
