package greedy19;
import java.io.*;

class Main {
	static String S;
	static String T;
	static boolean answer = false;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			S = br.readLine();
			T = br.readLine();
			
			go(0, T.length() - 1);
			
			if(answer) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void go(int s, int e) {
		//System.out.println(s + " " + e);
		if(answer)
			return;
		if(Math.abs(s - e) + 1 == S.length()) {
			if(isSame(s, e)) {
				answer = true;
			}
			return;
		}
		
		if(T.charAt(s) == 'A' && T.charAt(e) == 'A') {
			if(s < e) go(s, e - 1);
			else go(s, e + 1);
		}
		else if(T.charAt(s) == 'A' && T.charAt(e) == 'B')
			return;
		else if(T.charAt(s) == 'B' && T.charAt(e) == 'A') {
			if(s < e) {
				go(s, e - 1);
				go(e, s + 1);
			}
			else {
				go(s, e + 1);
				go(e, s - 1);
			}
		}
		else {
			if(s < e) go(e, s + 1);
			else go(e, s - 1);
		}
	}
	
	public static boolean isSame(int s, int e) {
		if(s < e + 1) {
			//System.out.println(T.substring(s, e + 1));
			if(T.substring(s, e + 1).equals(S)) {
				return true;
			}
		}
		else {
			if(reverse(T.substring(e, s + 1)).equals(S)) {
				return true;
			}
		}
		return false;
	}
	
	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s).reverse();
		return sb.toString();
	}
}