package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.Diary;
import com.example.mapper.DiaryMapper;

@Service
@Transactional
public class DiaryService {

	@Autowired
	private DiaryMapper mapper;
	
	public void create(Diary diary) throws Exception {
		if (diary.getTitle().isEmpty()) {
			throw new Exception("タイトルは必須です");
		}
		if (diary.getText().isEmpty()) {
			throw new Exception("内容は必須です");
		}
		mapper.create(diary);
	}
	
	public void update(Diary diary) {
		mapper.update(diary);
	}
	
	public List<Diary> findAll() {
		return mapper.findAll();
	}
	
	public Diary findById(int id) {
		return mapper.findById(id);
	}
	
	public void delete(int id) {
		mapper.delete(id);
	}
}
