package com.test.main;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.Deloitte.service.UrlShorteningService;
import com.test.main.utils.TestUtils;

public class Test1 extends TestUtils{

	@Test
	public void testShorlUrl() {
		UrlShorteningService ser = new UrlShorteningService();
		String url = ser.getShortUrl("https://vaibhav.company.com");
		Boolean condition = true;
		String[] temp = url.split("/");
		try {
			int i = Integer.valueOf(temp[temp.length-1]);
			if(i<10000000)
				condition=false;
		}
		catch (NumberFormatException e) {
			condition=false;
			// TODO: handle exception
		}
		assertTrue(url, condition);
	}
	
	@Test
	public void testNoLongUrl() {
		UrlShorteningService ser = new UrlShorteningService();
		
		String url = ser.getLongUrl("http://test/21813650");
		//System.out.println(url);
		assertEquals("No records Found", url, "passed");
	}
	
	@Test
	public void testLongUrl() {
		UrlShorteningService ser = new UrlShorteningService();
		String shorturl = ser.getShortUrl("https://xyz.company.com");
		String url = ser.getLongUrl(shorturl);
		assertEquals("https://xyz.company.com", url, "passed");
	}
}
