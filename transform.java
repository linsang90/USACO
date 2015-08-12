/*
 ID: linsang1
 TASK: transform
 LANG: JAVA
 */

import java.io.*;
import java.util.*;

public class transform {
	public static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		
		//Read input file and initialize. 
		N = Integer.parseInt(f.readLine());
		char[][] mtrxBefore = new char[N][N];
		char[][] mtrxAfter = new char[N][N];
		
		for(int i = 0;i < N; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			mtrxBefore[i] = st.nextToken().toCharArray();		
		}
		
		for(int i = 0;i < N; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			mtrxAfter[i] = st.nextToken().toCharArray();		
		}
		
		//Judge.
		if(r90(mtrxBefore,mtrxAfter)) out.println(1);
		else if(r180(mtrxBefore,mtrxAfter)) out.println(2);
		else if(r270(mtrxBefore,mtrxAfter)) out.println(3);
		else if(ref(mtrxBefore,mtrxAfter)) out.println(4);
		else if(combine(mtrxBefore,mtrxAfter)) out.println(5);
		else if(same(mtrxBefore,mtrxAfter)) out.println(6);
		else out.println(7);
		
		//Exit.
		f.close();
		out.close();
		System.exit(0);
	}
	
	public static boolean r90(char[][] a, char[][] b) {
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < N; j++) 
				if(a[i][j] != b[j][N - 1 - i]) return false;
		
		return true;
	}
	
	public static boolean r180(char[][] a, char[][] b) {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++) 
				if(a[i][j] != b[N - 1 - i][N - 1 - j]) return false;
		
		return true;
	}
	
	public static boolean r270(char[][] a, char[][] b) {
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < N ; j++) 
				if(a[i][j] != b[N - 1 - j][i]) return false;
		
		return true;
	}
	
	public static boolean ref(char[][] a, char[][] b) {
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < N ; j++) 
				if(a[i][j] != b[i][N - 1 - j]) return false;
		
		return true;
	}
	
	public static boolean combine(char[][] a, char[][] b) {
		char[][] c = new char[N][N];
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < N ; j++) 
				c[i][j] = a[i][N - 1 - j];
		
		return r90(c,b) || r180(c,b) || r270(c,b);
	}
	
	public static boolean same(char[][] a, char[][] b) {
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < N ; j++) 
				if(a[i][j] != b[i][j]) return false;
		
		return true;
	}
}
