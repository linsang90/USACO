/*
 ID: linsang1
 TASK: friday
 LANG: JAVA
 */ 
import java.io.*;
import java.util.*;

public class friday {
	
	 public static Integer[] unleap13 = new Integer[]{13,44,72,103,133,164,194,225,256,286,317,347}; 
	 public static Integer[] leap13 = new Integer[]{13,44,73,104,134,165,195,226,257,287,318,348};
	 public static Set<Integer> unleap = new HashSet<Integer>(Arrays.asList(unleap13));
	 public static Set<Integer> leap = new HashSet<Integer>(Arrays.asList(leap13));
	 public static void main(String[] args) throws IOException {
	 
		 BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));		 
		 int n = Integer.parseInt(f.readLine());
		 
		 int[] week = new int[7];
		 int start = 6;
		 
		 for(int i=0;i<n;i++) {
			 int year = 1900 + i;
			 if(year % 400 == 0 || (year % 4 == 0 && (year % 100 != 0))) {
				 start = record(week, true,start);
			 }
			 else start = record(week,false,start);
		 }
		 
		 out.print(week[5] + " ");
		 out.print(week[6] + " ");
		 out.print(week[0] + " ");
		 out.print(week[1] + " ");
		 out.print(week[2] + " ");
		 out.print(week[3] + " ");
		 out.println(week[4]);
		 out.close();
		 System.exit(0);
		 
	 }
	 
	 public static int record(int[] week,boolean isLeap,int start) {
		int days = isLeap ? 366 : 365;
		 for(int i=1;i<=days;i++) {
			 if(isThirteenth(i,isLeap)) 
				 week[(start + i%7)%7] ++;
		 }
		 return (start + days%7) % 7;
	 }
	 
	 public static boolean isThirteenth(int day,boolean isLeap) {
		 if(isLeap && leap.contains(day)) return true;
		 else if(!isLeap && unleap.contains(day)) return true;
		 else return false;
	 }
	 
}
