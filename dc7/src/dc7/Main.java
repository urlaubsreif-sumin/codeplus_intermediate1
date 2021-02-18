package dc7;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int r;
	static int c;
	static int ans = -1;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			go(N, 0, 0, 0);
			
			System.out.println(ans);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void go(int n, int i, int j, int cnt) {
		if(ans != -1) {
			return;
		}
		
		if(n == 0) {
			if(r == i && c == j) ans = cnt;
			else if(r == i && c == j + 1) ans = cnt + 1;
			else if(r == i + 1 && c == j) ans = cnt + 2;
			else if(r == i + 1 && c == j + 1) ans = cnt + 3;
			return;
		}
		
		int k = (int)Math.pow(2, n - 1);
		if(r < i + k && c < j + k) {
			go(n - 1, i, j, cnt);
		}
		else if(r < i + k) {
			go(n - 1, i, j + k, cnt + (int)Math.pow(k,  2));
		}
		else if(c < j + k) {
			go(n - 1, i + k, j, cnt + 2 * (int)Math.pow(k, 2));
		}
		else {
			go(n - 1, i + k, j + k, cnt + 3 * (int)Math.pow(k, 2));
		}		
	}
}
