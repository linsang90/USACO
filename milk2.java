/*
 ID: linsang1
 TASK: milk2
 LANG: JAVA
 */ 
import java.io.*;
import java.util.*;

public class milk2 {
	static class Farmer implements Comparable<Farmer> {
		public int start;
		public int end;
		
		Farmer(int s, int e) {
			this.start = s;
			this.end = e;
		}

		@Override
		public int compareTo(Farmer o) {
			if(this.start > o.start) return 1;
			else if(this.start < o.start) return -1;
			return 0;
		}
	}
	
	 public static void main(String[] args) throws IOException {
	 
		 BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));		 
		 
		 int N = Integer.parseInt(f.readLine());
		 Farmer[] farmers = new Farmer[N];
		 
		 String line;
		 int i = 0;
		 while((line = f.readLine()) != null && !line.equals("")) {
			 StringTokenizer st = new StringTokenizer(line);
			 int start = Integer.parseInt(st.nextToken());
			 int end = Integer.parseInt(st.nextToken());
			 farmers[i++] = new Farmer(start,end);
		 }
		 Arrays.sort(farmers);
		 int tmpStart = farmers[0].start;
		 int tmpEnd = farmers[0].end;
		 int maxMilkTime = tmpEnd - tmpStart;
		 int maxIdleTime = 0;
		 for(i = 1; i < N; i++) {
			 if(farmers[i].start <= tmpEnd) {
				 tmpEnd = Math.max(tmpEnd,farmers[i].end);
				 maxMilkTime = Math.max(maxMilkTime, tmpEnd - tmpStart);
			 }
			 else {
				 maxMilkTime = Math.max(maxMilkTime, tmpEnd - tmpStart);
				 maxIdleTime = Math.max(maxIdleTime, farmers[i].start - tmpEnd);
				 tmpStart =farmers[i].start;
				 tmpEnd = farmers[i].end;
				 
			 }
		 }
		 out.println(maxMilkTime + " " + maxIdleTime);
		 out.close();
		 System.exit(0);
	 }
}
