package dc1;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] sangeun;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
				
		try {
			N = Integer.parseInt(br.readLine());
			sangeun = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				sangeun[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(sangeun);
			
			int M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				int n = Integer.parseInt(st.nextToken());
				boolean res = search(n, 0, N - 1);
				sb.append(res ? 1 : 0).append(' ');
			}
			
			System.out.println(sb.toString());
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean search(int n, int l, int r) {
		boolean res = false;
		int m = (l + r) / 2;
		
		if(l > r)
			return false;
		if(n == sangeun[m]) {
			return true;
		}
		
		if(n < sangeun[m]) {
			res = search(n, l, m - 1);
		}
		else if(n > sangeun[m]) {
			res = search(n, m + 1, r);
		}
		if(res) {
			return true;
		}
		return false;
	}

}
