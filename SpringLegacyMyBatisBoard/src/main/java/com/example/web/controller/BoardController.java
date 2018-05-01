package com.example.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.board.dto.Pager;
import com.example.board.model.Board;
import com.example.board.repository.BoardMapper;
import com.example.user.model.User;

@Controller
@RequestMapping("/boards")
public class BoardController {
	@Autowired
	private BoardMapper boardMapper;
	
	@ModelAttribute("active")
	public String active(){
		return "board";
	}
	
	@GetMapping()
	public ModelAndView getBoardsView(
			@RequestParam(name="page", required=false, defaultValue="1") int page,
			@RequestParam(name="size", required=false, defaultValue="10") int size,
			@RequestParam(name="bsize", required=false, defaultValue="5") int bsize) {
		ModelAndView mav = new ModelAndView("board_list");
		mav.addObject("boards", boardMapper.selectByLimit(page, size));
		mav.addObject("pager", new Pager(page, size, bsize, boardMapper.count()));
		return mav;
	}
	
	@GetMapping("/view/{id}")
	public String getBoardView(@PathVariable long id, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return session.getServletContext().getContextPath() + "/login";
		}
		
		boardMapper.increment(id, user.getEmail());
		model.addAttribute("board", boardMapper.selectById(id));
		return "board_view";
	}
	
	@GetMapping("/write")
	public String getInsertView(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return session.getServletContext().getContextPath() + "/login";
		}
		model.addAttribute("user", user);
		return "board_write";
	}
	
	@PostMapping("/write")
	public String postInsert(Board board, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		
		if (user != null && board != null) {
			if (user.getEmail().equals(board.getWriter())) {
				boardMapper.insert(board);
				return "redirect:/boards";
			}
		}
		return session.getServletContext().getContextPath() + "/boards";
	}
	
	@GetMapping("/update/{id}")
	public String getUpdateView(@PathVariable long id, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		Board board = boardMapper.selectById(id);
		
		if (user != null && board != null) {
			if (user.getEmail().equals(board.getWriter())) {
				model.addAttribute("board", board);
				return "board_update";
			}
		}
		return session.getServletContext().getContextPath() + "/boards";
	}
	
	@PostMapping("/update")
	public String postUpdate(Board board, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		
		if (user != null && board != null) {
			if (user.getEmail().equals(board.getWriter())) {
				boardMapper.update(board);
				return "redirect:/boards/view/" + board.getId();
			}
		}
		return session.getServletContext().getContextPath() + "/boards";
	}
	
	@GetMapping("/delete/{id}")
	public String getDelete(@PathVariable long id, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		
		if (user != null) {
			Board board = boardMapper.selectById(id);
			
			if (user.getEmail().equals(board.getWriter())) {
				boardMapper.delete(id);
				return "redirect:/boards";
			}
		}
		return session.getServletContext().getContextPath() + "/boards";
	}
	
}
