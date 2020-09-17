package com.Deloitte.model;

import java.time.LocalDateTime;

public class ShortUrl {
	
	
	private int shortId;
	private LocalDateTime expiredTime;
	private LocalDateTime creationTime;
	
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}
	
	public int getShortId() {
		return shortId;
	}
	public void setShortId(int shortId) {
		this.shortId = shortId;
	}
	public LocalDateTime getExpiredTime() {
		return expiredTime;
	}
	public void setExpiredTime(LocalDateTime expiredTime) {
		this.expiredTime = expiredTime;
	}
	public ShortUrl(int shortId, LocalDateTime creationTime) {
		super();
		this.shortId = shortId;
		this.expiredTime = creationTime.plusHours(4);
		this.creationTime = creationTime;
	}
	
	

}
