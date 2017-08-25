package com.nisum.gitAPIResponse;

/**
 * Encapsulates the file response
 * @author harunachala
 *
 */
public class File {
	
	/**
    "name": "file1.txt",
    "path": "sharedFiles/Files/file1.txt",
    "sha": "655fb30f8674238388f15aa727f8755f4349022f",
    "size": 143,
    "url": "https://api.github.com/repos/fileowner9009/SharedFiles/contents/sharedFiles/Files/file1.txt?ref=master",
    "html_url": "https://github.com/fileowner9009/SharedFiles/blob/master/sharedFiles/Files/file1.txt",
    "git_url": "https://api.github.com/repos/fileowner9009/SharedFiles/git/blobs/655fb30f8674238388f15aa727f8755f4349022f",
    "download_url": "https://raw.githubusercontent.com/fileowner9009/SharedFiles/master/sharedFiles/Files/file1.txt",
    "type": "file",
    "_links": {
        "self": "https://api.github.com/repos/fileowner9009/SharedFiles/contents/sharedFiles/Files/file1.txt?ref=master",
        "git": "https://api.github.com/repos/fileowner9009/SharedFiles/git/blobs/655fb30f8674238388f15aa727f8755f4349022f",
        "html": "https://github.com/fileowner9009/SharedFiles/blob/master/sharedFiles/Files/file1.txt"
    }
    */

	private String name;
	private String path;
	private String sha;
	private int size;
	private String url;
	private String html_url;
	private String git_url;
	private String download_url;
	private String type;
	private Links _links;
	
	public File() {
		super();
	}

	public File(String name, String path) {
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

	public String getSha() {
		return sha;
	}

	public void setSha(String sha) {
		this.sha = sha;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHtml_url() {
		return html_url;
	}

	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}

	public String getGit_url() {
		return git_url;
	}

	public void setGit_url(String git_url) {
		this.git_url = git_url;
	}

	public String getDownload_url() {
		return download_url;
	}

	public void setDownload_url(String download_url) {
		this.download_url = download_url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Links get_links() {
		return _links;
	}

	public void set_links(Links _links) {
		this._links = _links;
	}
	
	

}
