package com.Deloitte.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;

import com.Deloitte.model.ShortUrl;

public class UrlShorteningService {

	 public static HashMap<String,ShortUrl> urlMap = new HashMap<>();
	 public static HashSet<Integer> keySet = new HashSet<>();
	static String urlPre= "http://test/";
	
	
	
	
	public UrlShorteningService() {
		super();
	}


	public String getShortUrl(String longUrl) {
		if(urlMap.isEmpty()) {
			int key = KeyMgmtService.generateKey(8);
			urlMap.put(longUrl, new ShortUrl(key, LocalDateTime.now()));
			keySet.add(key);
			return urlPre+key;
		}
		
		if(!urlMap.containsKey(longUrl)) {
			int key = KeyMgmtService.generateKey(8);
			while(!keySet.add(key))
				key=KeyMgmtService.generateKey(8);
			urlMap.put(longUrl, new ShortUrl(key, LocalDateTime.now()));
			return urlPre+key;
		}
		else {
			ShortUrl shortUrl = urlMap.get(longUrl);
			if(shortUrl.getExpiredTime().isBefore(LocalDateTime.now())){
				
				int key = KeyMgmtService.generateKey(8);
				while(!keySet.add(key))
					key=KeyMgmtService.generateKey(8);
				urlMap.put(longUrl, new ShortUrl(key, LocalDateTime.now()));
				//keySet.remove(shortUrl.getShortId());
				return urlPre+key;
			}
			return urlPre+shortUrl.getShortId();
		}		
	}
	
	
	public String getLongUrl(String shortUrl) {
		String[] temp = shortUrl.split("/");
		int key = Integer.valueOf(temp[temp.length-1]);
		
		if(keySet.contains(key)) {
			return urlMap.entrySet().stream().filter(entry-> entry.getValue().getShortId()==key).findFirst().get().getKey();
		}
		else {
			return "No records Found";
		}
	}
}
