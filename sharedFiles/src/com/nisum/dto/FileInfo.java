package com.nisum.dto;


public class FileInfo {
	
	private String name;
	private String path;
	
	public FileInfo() {
		super();
	}

	public FileInfo(String name, String path) {
		super();
		this.name = name;
		this.path = path;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	

}
