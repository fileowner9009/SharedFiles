package com.nisum.dto;

import java.util.List;

public class FileContentsBean {
	
	private String message;
	
	private List<FileRow> fileRows;
	
	private String fileName;
	
	private String newCityName;
	
	private String newStateName;
	
	private String newCountryName;
	
	public FileContentsBean() {
		super();
	}

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public List<FileRow> getFileRows() {
		return fileRows;
	}

	public void setFileRows(List<FileRow> fileRows) {
		this.fileRows = fileRows;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getNewCityName() {
		return newCityName;
	}

	public void setNewCityName(String newCityName) {
		this.newCityName = newCityName;
	}

	public String getNewStateName() {
		return newStateName;
	}

	public void setNewStateName(String newStateName) {
		this.newStateName = newStateName;
	}

	public String getNewCountryName() {
		return newCountryName;
	}

	public void setNewCountryName(String newCountryName) {
		this.newCountryName = newCountryName;
	}
	
}
