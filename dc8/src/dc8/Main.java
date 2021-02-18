package dc8;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] piece;
	static int[][] move = {{2, 1}, {3, 4}};
	static long r, c;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		try {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			piece = new int[n];
			String s = st.nextToken();
			for(int i = 0; i < n; i++) {
				piece[i] = s.charAt(i) - '0';
			}
			
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			
			pos(0, 0, n - 1);
			int[] ans = move(x, y);
			
			if(ans[0] == -1) {
				sb.append(-1);
			}
			else {
				for(int t : ans) {
					sb.append(t);
				}
			}
			
			System.out.println(sb.toString());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	public static void pos(long i, long j, int k) {
		if(k < 0) {
			r = i;
			c = j;
			return;
		}
		int num = piece[n - 1 - k];
		long p = (long)Math.pow(2, k);
		if(num >= 3) {
			i += p;
		}
		if(num == 1 || num == 4) {
			j += p;
		}
		pos(i, j, k - 1);
	}
	
	public static int[] move(long x, long y) {
		long i = r - y;
		long j = c + x;
		int[] ans = new int[n];
		
		if(i >= Math.pow(2, n) || j >= Math.pow(2, n) || i < 0 || j < 0) {
			ans[0] = -1;
			return ans;
		}
		
		int pos = n - 1;
		while(pos >= 0) {
			if(i >= Math.pow(2, pos)) {
				ans[n - 1 - pos] = 3;
				i -= Math.pow(2, pos);
			}
			else {
				ans[n - 1 - pos] = 2;
			}
			pos--;
		}
		
		pos = n - 1;
		while(pos >= 0) {
			if(j >= Math.pow(2, pos)) {
				ans[n - 1 - pos] = ans[n - 1 - pos] * 3 % 5;
				j -= Math.pow(2, pos);
			}
			else {
				ans[n - 1 - pos] = (ans[n - 1 - pos] + 3) / 2;
			}
			pos--;
		}
		
		return ans;
	}

}
