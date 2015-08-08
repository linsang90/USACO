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
		 
		 for(int i = 0; i < 2 * N; i++) {
			 int m1 = 0;
			 char a = 'w';
			 boolean first = true;
			 for(int k = i; k < 2 * N; k++) {
				 if(lace.charAt(k) == a || lace.charAt(k) == 'w') {
					 m1 ++;
				 }
				 else if(lace.charAt(k) != 'w') {
					 if(first) {
						 first = false;
						 m1 ++ ;
						 a = lace.charAt(k);
					 }
					 else
						 break;
				 }
			 }
			 int m2 = 0;
			 a = 'w';
			 first = true;
			 for(int k = i - 1; k >= 0;k --) {
				 if(lace.charAt(k) == a || lace.charAt(k) == 'w') {
					 m2 ++;
				 }
				 else if (lace.charAt(k) != 'w') {
					 if(first) {
						 first = false;
						 m2 ++;
						 a = lace.charAt(k);
					 }
					 else 
						 break;
				 }
			 }
			 max = Math.max(max, m1 + m2);
			 
		 }
		 if(max > N) max = N;
		 out.println(max);
		 out.close();
		 System.exit(0);
	 }
}
