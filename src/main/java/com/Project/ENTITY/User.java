package com.Project.ENTITY;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class User
{
	@Id
	private String username;
	private String password;
	private String emailid;
	private long mobileno;
	private String imagepath;
	
	private transient MultipartFile image;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", emailid=" + emailid + ", mobileno="
				+ mobileno + ", imagepath=" + imagepath + "]";
	}
	
	
}
