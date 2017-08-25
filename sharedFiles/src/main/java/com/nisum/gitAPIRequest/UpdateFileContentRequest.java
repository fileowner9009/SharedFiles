package com.nisum.gitAPIRequest;

public class UpdateFileContentRequest {
	
	private String message;
	private Committer committer;
	private String content;
	private String sha;

	public UpdateFileContentRequest(String message, String committerName, String committerEmail,String content, String sha) {
		super();
		this.message = message;
		this.committer = new Committer(committerName, committerEmail);
		this.content = content;
		this.sha = sha;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Committer getCommitter() {
		return committer;
	}

	public void setCommitter(Committer committer) {
		this.committer = committer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSha() {
		return sha;
	}

	public void setSha(String sha) {
		this.sha = sha;
	}

	class Committer{
		private String name;
		private String email;
		
		public Committer(String name, String email) {
			super();
			this.name = name;
			this.email = email;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
	}
	
}
	
