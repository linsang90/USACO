/*
 ID: linsang1
 TASK: crypt1
 LANG: JAVA
 */

import java.io.*;
import java.util.*;

public class crypt1 {
	static boolean[] table;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter(new FileWriter("crypt1.out"));
		int N = Integer.parseInt(f.readLine());
		StringTokenizer st= new StringTokenizer(f.readLine());
		table = new boolean[10];
		while(st.hasMoreTokens()) {
			int i = Integer.parseInt(st.nextToken());
			table[i] = true;
		}
		
		int cnt = 0;
		for(int fNum = 111; fNum <= 999; fNum++)
			for(int sNum = 11; sNum <= 99; sNum++) {
				if(!hasNumber(fNum) || !hasNumber(sNum)) continue;
				int p1 = fNum * (sNum % 10);
				int p2 = fNum * (sNum / 10);
				int res = fNum * sNum;
				if(p1 > 999 || p2 > 999 || res > 9999) continue;
				else if(!hasNumber(p1) || !hasNumber(p2) || !hasNumber(res)) continue;
				else cnt++;
			}
//		System.out.print(hasNumber(241));
		
		out.println(cnt);
		out.close();
		System.exit(0);
	}
	
	private static boolean hasNumber(int i) {
		int n = i;
		while(n > 0) {
			if(table[n % 10] == false) return false;
			else n = n / 10;
		}
		return true;
	}
}
