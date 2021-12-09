package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.Diary;

@Mapper
public interface DiaryMapper {

	void create(Diary diary);
	void update(Diary diary);
	List<Diary> findAll();
	Diary findById(int id);
	void delete(int id);
}
