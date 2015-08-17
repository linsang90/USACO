/*
 ID: linsang1
 TASK: barn1
 LANG: JAVA
 */

import java.io.*;
import java.util.*;

public class barn1 {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new FileWriter("barn1.out"));
		StringTokenizer st= new StringTokenizer(f.readLine());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] stalls = new int[C];
		String line;
		int i = 0, min = S, max = 0;
		while((line = f.readLine()) != null && !line.equals("")) {
			int n = Integer.parseInt(line);
			stalls[i++] = n;
			max = Math.max(max, n);
			min = Math.min(min, n);
		}
		
		Arrays.sort(stalls);
		int[] interval = new int[C -1];
		for(i = 0; i < C - 1; i++) {
			interval[i] = stalls[i] - stalls[i+1] + 1;
		}

		int number = max - min + 1;
		Arrays.sort(interval);
		for(int j = 0; j < M - 1 && j < interval.length;j++) {
			number += interval[j];
		}
		
		out.println(number);
		out.close();
		System.exit(0);
	}
}
