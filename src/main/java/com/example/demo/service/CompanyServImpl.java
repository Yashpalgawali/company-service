package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Company;
import com.example.demo.repository.CompanyRepo;

@Service("compserv")
public class CompanyServImpl implements CompanyService {

	@Autowired
	CompanyRepo comprepo;
	
	@Override
	public Company saveCompany(Company comp) {
		// TODO Auto-generated method stub
		return comprepo.save(comp);
	}

	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return comprepo.findAll();
	}

	@Override
	public Company getCompanybyId(Long id) {
		// TODO Auto-generated method stub
		
		Optional<Company> comp = comprepo.findById(id);
		if(comp!=null){
			return comp.get();
		}
		else
		{
			return null;
		}
		
	}

}
