package com.example.board.dto;

import lombok.Data;

@Data
public class Pager {
	private int page; // current page
	private int size; // rows per page
	private int bsize; // pages per block

	private int rows; // total elements
	private int pages; // total pages
	private int blocks; // total blocks

	private int block; // current block
	private int bspage; // current block start page
	private int bepage; // current block end page

	public Pager(int page, int size, int bsize, int rows) {
		this.page = page;
		this.size = size;
		this.bsize = bsize;
		this.rows = rows;

		pages = (int) Math.ceil((double) this.rows / this.size);
		blocks = (int) Math.ceil((double) pages / this.bsize);

		block = (int) Math.ceil((double) this.page / this.bsize);
		bepage = block * this.bsize;
		bspage = bepage - this.bsize + 1;
	}
	
	public static int seekOffset(int page, int size) {
		if (page > 0) {
			return (page - 1) * size;
		}
		return 0;
	}

	public static int seekStart(int page, int size) {
		return ((page - 1) * size) + 1;
	}

	public static int seekEnd(int page, int size) {
		return page * size;
	}
}
