package com.nisum.dto;


public class FileInfo {
	
	private String name;
	private String path;
	private String sha;
	private String downloadUrl;
	
	public FileInfo() {
		super();
	}

	public FileInfo(String name, String path, String downloadUrl, String sha) {
		super();
		this.name = name;
		this.path = path;
		this.sha = sha;
		this.downloadUrl = downloadUrl;
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
	
	
	public String getSha() {
		return sha;
	}

	public void setSha(String sha) {
		this.sha = sha;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

}
