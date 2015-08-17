/*
 ID: linsang1
 TASK: dualpal
 LANG: JAVA
 */

import java.io.*;
import java.util.*;

public class dualpal {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter out = new PrintWriter(new FileWriter("dualpal.out"));
		StringTokenizer st= new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		f.close();
		
		int count = 0, i = S + 1;
		while(count < N) {
			int dual = 0;
			for(int base = 2; base <= 10; base++) {
				String s = convertor(i,base);
				if(isPalindrome(s)) {
					if(dual == 1) {
						out.println(i);
						count++;
						break;
					}
					else dual++;
				}
			}
			i++;
		}
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
