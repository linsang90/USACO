/*
 ID: linsang1
 TASK: friday
 LANG: JAVA
 */ 
import java.io.*;
import java.util.*;

public class friday {
	
	private static final int[] mgap = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	 public static void main(String[] args) throws IOException {
	 
		 BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));		 
		 int n = Integer.parseInt(f.readLine());
		 
		 int[] week = new int[7];
		 int day = 0;
		 
		 for(int y=1900;y<1900 + n;y++) 
			 for(int m=0;m<12;m++) {
				 week[day] ++ ;
				 day = (day + mLength(y,m))%7; 
			 }
		 
		 for(int i=0;i<7;i++) {
			 if(i>0) out.print(" ");
			 out.print(week[i]);
		 }
		 out.println();
		 out.close();
		 System.exit(0);
		 
	 }
	 
	 private static int isLeap(int y) {
		if( y % 400 == 0 || y % 4 == 0 && y % 100 != 0) return 1;
		else return 0;
	 }
	 
	 private static int mLength(int y, int m) {
		 if(m == 1) return mgap[m] + isLeap(y);
		 else return mgap[m];
	 }
}
