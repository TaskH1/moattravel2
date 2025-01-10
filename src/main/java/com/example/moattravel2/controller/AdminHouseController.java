package com.example.moattravel2.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.moattravel2.entity.House;
import com.example.moattravel2.repository.HouseRepository;

@Controller
@RequestMapping("/admin/houses")
public class AdminHouseController {
	//Declare a variable named houseRepository of type HouseRepository
	private final HouseRepository houseRepository;
	
	//Dependency Injection, DI
	public AdminHouseController(HouseRepository houseRepository) {
		this.houseRepository = houseRepository;
	}
	
	@GetMapping
	public String index(Model model, @PageableDefault(page = 0, size = 10, sort = "id",
	direction = Direction.ASC) Pageable pageable) {
		Page<House> housePage = houseRepository.findAll(pageable);
		
		//addAttribute(referred variable name, passed data to a view)
		model.addAttribute("housePage", housePage);
		
		return "admin/houses/index";
	}
	
	

}
