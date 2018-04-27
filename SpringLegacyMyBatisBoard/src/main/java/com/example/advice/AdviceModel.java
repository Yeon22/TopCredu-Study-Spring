package com.example.advice;

import lombok.Data;

@Data
public class AdviceModel {
	private String Name;
	private String pointcut;
	private String elapsedtime;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getPointcut() {
		return pointcut;
	}
	public void setPointcut(String pointcut) {
		this.pointcut = pointcut;
	}
	public String getElapsedtime() {
		return elapsedtime;
	}
	public void setElapsedtime(String elapsedtime) {
		this.elapsedtime = elapsedtime;
	}
}
