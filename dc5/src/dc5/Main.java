package dc5;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int res = 0;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine());
			
			go(N, 0, 2);
			sb.insert(0, '\n').insert(0, res);
			
			System.out.println(sb.toString());
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void go(int n, int from, int to) {
		if(n == 1) {
			sb.append(from + 1).append(' ').append(to + 1).append('\n');
			res++;
			return;
		}
		go(n - 1, from, 3 - to - from);
		go(1, from, to);
		go(n - 1, 3 - to - from, to);
	}

}
