/*
 ID: linsang1
 TASK: namenum
 LANG: JAVA
 */
import java.io.*;
import java.util.*;

public class namenum {

	public static Set<String> dict = new HashSet<String>();
	public static final String[] letters = new String[] {" ", " ","ABC","DEF","GHI",
		"JKL","MNO","PRS","TUV","WXY"}; 
	public static int CNT;
	public static void main(String[] args) throws IOException {
		
		//Deal with input file and initialize.
		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		BufferedReader d = new BufferedReader(new FileReader("dict.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("namenum.out"));
		
		String number = f.readLine();
		f.close();
		
		String line;
		while((line = d.readLine()) != null && !line.equals("")) 
			dict.add(line);
		d.close();
		
		//Judge.
//		boolean hasName = false;
//		LinkedList<String> possName = new LinkedList<String>();
//		possName.add("");
//		for(int i = 0; i < number.length(); i++) {
//			int index = number.charAt(i) - '0';
//			while(possName.peek().length() == i) {
//				String t = possName.remove();
//				for(char c : letters[index].toCharArray()) {
//					possName.add(t + c);
//					if((t + c).length() == number.length()) {
//						if(dict.contains(t + c)) {
//							out.println(t + c);
//							hasName = true;
//						}
//					}
//				}
//			}
//		}
//		if(!hasName) out.println("NONE");
		char[][] keypad = new char[][] {
                {},
                {},
                {'A','B','C'},
                {'D','E','F'},
                {'G','H','I'},
                {'J','K','L'},
                {'M','N','O'},
                {'P','R','S'},
                {'T','U','V'},
                {'W','X','Y'}
        };
		build(0,number,new StringBuilder(),keypad,dict,out);
		if(CNT == 0) out.println("NONE");
		//Exit.
		out.close();
		System.exit(0);
	}
	private static void build(int index, String input, StringBuilder sb, char[][] keypad, Set<String> dict, PrintWriter pw) {
        if (sb.length() != input.length()) {
            int key = Integer.parseInt(input.charAt(index)+"");
            for(int i=0; i<keypad[key].length; i++) {
                build(index+1, input, new StringBuilder(sb).append(keypad[key][i]), keypad, dict, pw);
            }
        } else {
            String target = sb.toString();
            if (dict.contains(target)) {
                CNT++;
                pw.println(sb.toString());
            }
        }
    }
}
