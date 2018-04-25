package com.mkyong1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mkyong1.dao.CustomerDAO;

@Component
public class CustomerService {
	@Autowired
	CustomerDAO cDao;
	
	public void setcDao(CustomerDAO cDao) {
		this.cDao = cDao;
	}

	@Override
	public String toString() {
		return "CustomerService [customerDao=" + cDao + "]";
	}
	
}
