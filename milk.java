/*
 ID: linsang1
 TASK: milk
 LANG: JAVA
 */

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class milk {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new FileWriter("milk.out"));
		StringTokenizer st= new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Farmer[] farmers = new Farmer[M];
		String line;
		int i = 0;
		while((line = f.readLine())!= null && !line.equals("")) {
			StringTokenizer st1 = new StringTokenizer(line);
			int price = Integer.parseInt(st1.nextToken());
			int amount = Integer.parseInt(st1.nextToken());
			farmers[i++] = new Farmer(price, amount);
		}
		
		Arrays.sort(farmers);
		int cost = 0;
		for (Farmer fa : farmers) {
		     int price = fa.price;
		     int amount = fa.amount;
		     if(N >= amount) {
		    	 cost += price * amount;
		    	 N -= amount;
		     }
		     else {
		    	 cost += price * N;
		    	 break;
		     }
		}
		out.println(cost);
		out.close();
		System.exit(0);
	}
}
	
	class Farmer implements Comparable<Farmer> {

		public int price;
		public int amount;

		public Farmer(int p, int a) {
			this.price = p;
			this.amount = a;
		}

		@Override
		public int compareTo(Farmer o) {
			if(this.price > o.price) return 1;
			else if(this.price < o.price) return -1;
			else return 0;
		}
	
}
