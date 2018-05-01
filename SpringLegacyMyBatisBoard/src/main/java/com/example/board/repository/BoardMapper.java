package com.example.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.board.model.Board;

@Mapper
public interface BoardMapper {
	public int insert(Board board);
	public int update(Board board);
	public int delete(long id);
	
	@Select("SELECT COUNT(*) FROM xboard")
	public int count();
	@Select("SELECT * FROM xboard ORDER BY id DESC")
	public List<Board> selectAll();
	
	public Board selectById(long id);
	public List<Board> selectByLimit(@Param("page") int page, @Param("size") int size);
	public int increment(@Param("id") long id, @Param("requester") String requester);
	
	public List<Board> searchSelectByTitle(@Param("page") int page, @Param("size") int size, @Param("title") String title);
	public List<Board> searchSelectByWriter(@Param("page") int page, @Param("size") int size, @Param("writer") String name);
	public List<Board> searchSelectByContent(@Param("page") int page, @Param("size") int size, @Param("content") String content);
	public List<Board> searchSelectByAll(@Param("page") int page, @Param("size") int size, @Param("all") String all);
	
	public int countByTitle(@Param("title") String title);
	public int countByWriter(@Param("writer") String writer);
	public int countByContent(@Param("content") String content);
	public int countByAll(@Param("all") String all);
}
