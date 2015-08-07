/*
 ID: linsang1
 TASK: gift1
 LANG: JAVA
 */ 
import java.io.*;
import java.util.*;

public class gift1 {
	 public static void main(String[] args) throws IOException {
	 
		 BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		 
		 int num = Integer.parseInt(f.readLine());
		 HashMap<String, Integer> map = new HashMap<String, Integer>();
		 int[] account = new int[num];
		 
		 for(int i=0;i<num;i++) {
			 String name = f.readLine();
			 map.put(name,i);
			 account[i] = 0;
		 }
		 String line;
		 while((line = f.readLine()) != null && !line.equals("")) {
			 String giverName  = line;
			 StringTokenizer st = new StringTokenizer(f.readLine());
			 int initialMoney = Integer.parseInt(st.nextToken());
			 account[map.get(giverName)] -= initialMoney;
			 int numGiven = Integer.parseInt(st.nextToken());
			 if(numGiven > 0)
				 account[map.get(giverName)] += (initialMoney - (initialMoney / numGiven) * numGiven);
			 for(int i=0;i<numGiven;i++) {
				 String givenName = f.readLine();
				 int givenIndex = map.get(givenName);
				 account[givenIndex] += initialMoney / numGiven;
			 }
		 }
		 
		 for(int i=0;i<num;i++) {
			 out.println(getKeyFromValue(map,i) +" "+ account[i]);
		 }
		 out.close();
		 System.exit(0);
		 
	 }
	 
	 public static Object getKeyFromValue(Map hm, Object value) {
		 for (Object o : hm.keySet()) {
			 if (hm.get(o).equals(value)) {
				 return o;
			 }
		 }
		 return null;
	 }
}
