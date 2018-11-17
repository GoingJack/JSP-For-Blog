package com.log;

public class log_review {
	private String title;
	private String id;
	private String details;
	public String gettitle(){
		return title;
	}
	public void settitle(String title){
		this.title=title;
	}
	public String getid(){
		return id;
	}
	public void setid(String id){
		this.id=id;
	}
	public String getdetails(){
		return details;
	}
	public void setdetails(String details){
		this.details=details;
	}
	public String toString(){
		return "title"+title+",id"+id+",details"+details;
	}
}
