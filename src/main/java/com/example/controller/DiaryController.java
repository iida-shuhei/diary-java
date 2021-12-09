package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Diary;
import com.example.service.DiaryService;

@RestController
@RequestMapping("/diary")
public class DiaryController {

	@Autowired
	private DiaryService service;
	
	@PostMapping
	public void create(@RequestBody Diary diary) throws Exception {
		try {
			service.create(diary);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Diary diary) throws Exception {
		try {			
			service.update(diary);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@GetMapping
	public List<Diary> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Diary findById(@PathVariable String id) {
		return service.findById(Integer.parseInt(id));
	}
	
	@PostMapping("/delete/{id}")
	public void delete(@PathVariable String id) {
		service.delete(Integer.parseInt(id));
	}
}
