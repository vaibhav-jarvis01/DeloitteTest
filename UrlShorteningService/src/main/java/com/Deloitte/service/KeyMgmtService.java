package com.Deloitte.service;

import java.util.Random;

public class KeyMgmtService {

	public static int generateKey(int n) {
	    int m = (int) Math.pow(10, n - 1);
	    return m + new Random().nextInt(9 * m);
	}
}
