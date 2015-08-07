/*
 ID: linsang1
 LANG: JAVA
 PROG: ride
 */
import java.io.*;
import java.util.*;

public class ride {
	 public static void main(String[] args) throws IOException {
	 
		 BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		 
		 String strComet = f.readLine();
		 String strGroup = f.readLine();
		 
		 int numComet = converter(strComet);
		 int numGroup = converter(strGroup);
		 
		 if(numComet == numGroup) out.println("GO");
		 else out.println("STAY");
		 out.close();
		 System.exit(0);
		 
	 }
	 public static int converter(String s) {
		 int product = 1;
		 for(char c : s.toCharArray()) {
			 int num = c - 'A' + 1;
			 product *= num;
		 }
		 return product % 47;
	 }
}
