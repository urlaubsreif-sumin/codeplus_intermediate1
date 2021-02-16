package dc2;
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
			Arrays.parallelSort(sangeun);
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				int n = Integer.parseInt(st.nextToken());
				int lb = lower_bound(n);
				if(lb == -1) {
					sb.append(0).append(' ');
				}
				else {
					int ub = upper_bound(n);
					sb.append(ub - lb + 1).append(' ');
				}
			}
			
			System.out.println(sb.toString());
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int lower_bound(int n) {
		int ans = -1;
		int l = 0, r = N - 1;
		while(l <= r) {
			int m = (l + r) / 2;
			if(sangeun[m] == n) {
				ans = m;
				r = m - 1;
			}
			else if(sangeun[m] > n) {
				r = m - 1;
			}
			else if(sangeun[m] < n) {
				l = m + 1;
			}
		}
		
		return ans;
	}
	
	public static int upper_bound(int n) {
		int ans = -1;
		int l = 0, r = N - 1;
		while(l <= r) {
			int m = (l + r) / 2;
			if(sangeun[m] == n) {
				ans = m;
				l = m + 1;
			}
			else if(sangeun[m] > n) {
				r = m - 1;
			}
			else if(sangeun[m] < n) {
				l = m + 1;
			}
		}
		return ans;
	}

}
