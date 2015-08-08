/*
 ID: linsang1
 TASK: beads
 LANG: JAVA
 */ 
import java.io.*;
import java.util.*;

public class beads {
	
	 public static void main(String[] args) throws IOException {
	 
		 BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));		 
		 int N = Integer.parseInt(f.readLine());
		 
		 String lace = f.readLine();
		 lace = lace + lace;
		 
		 int max = 0;
		 int[][] left = new int[2 * N + 1][2];
		 left[0][0] = 0;
		 left[0][1] = 0;
		 int[][] right = new int[2 * N + 1][2];
		 right[2 * N][0] = 0;
		 right[2 * N][1] = 0;
		 for(int i = 1; i <= 2 * N; i++) {
			if(lace.charAt(i - 1) == 'r') {
				left[i][0] = left[i - 1][0] + 1;
				left[i][1] = 0;
			}
			else if(lace.charAt(i - 1) == 'b') {
				left[i][0] = 0;
				left[i][1] = left[i - 1][1] + 1;
			}
			else {
				left[i][0] = left[i - 1][0] + 1;
				left[i][1] = left[i - 1][1] + 1;
			}
		 }
		 for(int i = 2 * N - 1; i >=  0; i--) {
			 if(lace.charAt(i) == 'r') {
				 right[i][0] = right[i + 1][0] + 1;
				 right[i][1] = 0;
				}
			else if(lace.charAt(i) == 'b') {
				right[i][0] = 0;
				right[i][1] = right[i + 1][1] + 1;
				}
			else {
				right[i][0] = right[i + 1][0] + 1;
				right[i][1] = right[i + 1][1] + 1;
				}
		 }
		 for(int i = 0; i < 2 * N; i++) 
			 max = Math.max(max, Math.max(left[i][0], left[i][1]) + Math.max(right[i][0], right[i][1]));
		 
		 if(max > N) max = N;
		 out.println(max);
		 out.close();
		 System.exit(0);
	 }
}
