package com.example.advice;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdviceMapper {
	public int insert(AdviceModel adviceModel);
	
	@Select("SELECT * FROM yeonaop")
	public ArrayList<AdviceModel> selectAll();
}
