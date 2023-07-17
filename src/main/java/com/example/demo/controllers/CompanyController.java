package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.Company;
import com.example.demo.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyService compserv;
	
	@PostMapping("/")
	public String saveCompany(@RequestBody Company comp)
	{
		if(compserv.saveCompany(comp)!=null)
		{
			return "redirect:/";
		}
		else
		{
			return "Company is not saved";
		}
	}
	
	@GetMapping("/")@ResponseBody
	public List<Company> viewCompanies()
	{
		List<Company> clist= compserv.getAllCompanies();
		return clist;
	}
	
	@GetMapping("/{id}")@ResponseBody
	public Company getCompanyById(@PathVariable("id") Long id)
	{
		Company clist= compserv.getCompanybyId(id);
		return clist;
	}
}
