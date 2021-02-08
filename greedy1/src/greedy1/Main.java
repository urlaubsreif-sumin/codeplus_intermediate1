package greedy1;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] coins;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			coins = new int[N];
			
			for(int i = 0; i < N; i++) {
				coins[i] = Integer.parseInt(br.readLine());
			}
			
			int ans = go(N, K);
			
			System.out.println(ans);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int go(int n, int k) {
		int idx = n - 1;
		int ans = 0;
		while(k > 0) {
			if(k / coins[idx] > 0) {
				ans += (k / coins[idx]);
				k = k % coins[idx];
			}
			idx--;
		}
		
		return ans;
	}

}
