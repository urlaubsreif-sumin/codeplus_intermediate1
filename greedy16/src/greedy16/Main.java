package greedy16;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			String S = br.readLine();
			String T = br.readLine();
			
			int len = S.length();
			int s = 0;
			int e = T.length() - 1;
			
			while(Math.abs(s - e) + 1 > len) {
				if(T.charAt(e) == 'B') {
					if(s > e) {
						e++;
					}
					else {
						e--;
					}
					int temp = s;
					s = e;
					e = temp;
				}
				else if(T.charAt(e) == 'A') {
					if(s > e) {
						e++;
					}
					else {
						e--;
					}
				}
				
			}
			if(s > e) sb.append(T.substring(e, s + 1)).reverse();
			else sb.append(T.substring(s, e + 1));
			
			if(S.equals(sb.toString()))
				System.out.println(1);
			else
				System.out.println(0);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
