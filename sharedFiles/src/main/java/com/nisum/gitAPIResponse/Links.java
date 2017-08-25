package com.nisum.gitAPIResponse;

/**
 * POJO to hold the _links values in the API response 
 * @author harunachala
 *
 */
public class Links {

	/**
	 *  "_links": {
        "self": "https://api.github.com/repos/fileowner9009/SharedFiles/contents/sharedFiles/Files/file1.txt?ref=master",
        "git": "https://api.github.com/repos/fileowner9009/SharedFiles/git/blobs/655fb30f8674238388f15aa727f8755f4349022f",
        "html": "https://github.com/fileowner9009/SharedFiles/blob/master/sharedFiles/Files/file1.txt"
    }
	 */
	
	private String self;
	private String git;
	private String html;
	
	public Links() {
		super();
	}

	public Links(String self, String git, String html) {
		super();
		this.self = self;
		this.git = git;
		this.html = html;
	}
	
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getGit() {
		return git;
	}
	public void setGit(String git) {
		this.git = git;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	
	
}
