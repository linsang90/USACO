/*
 ID: linsang1
 TASK: palsquare
 LANG: JAVA
 */

import java.io.*;
import java.util.*;

public class palsquare {
	public static final int min = 1;
	public static final int max = 300;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new FileWriter("palsquare.out"));
		
		int b = Integer.parseInt(f.readLine());
		f.close();

		for(int i = min; i < max; i++) {
			String square = convertor(i * i,b);
			if(isPalindrome(square)) out.println(convertor(i,b) + " " + square);
		}
//		System.out.print(isPalindrome("abba"));
//		System.out.print(convertor(10,12));
		out.close();
		System.exit(0);
	}
	
	private static String convertor(int num, int base) {
		StringBuilder sb = new StringBuilder();
		while(num > 0) {
			int digitI = num % base;
			char digitC = (char) ((digitI > 9)? ('A' + (digitI - 10)) : ('0' + digitI));
			sb.append(digitC);
			num = num / base;
		}
		
		return sb.reverse().toString();
	}
	
	private static boolean isPalindrome(String s) {
		int low = 0, high = s.length() - 1;
		while(low < high) {
			if(s.charAt(low) != s.charAt(high)) return false;
			low++;
			high--;
		}
		return true;
	}
}
