package bs3;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			tree = new long[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				tree[i] = Long.parseLong(st.nextToken());
			}
			
			long start = 1L;
			long end = 2000000000L;
			long ans = 0;
			while(start <= end) {
				long mid = (start + end) / 2;
				long res = go(mid);
				if(res < M) {
					end = mid - 1;
				}
				else if(res >= M) {
					start = mid + 1;
					ans = mid;
				}
			}
			
			System.out.println(ans);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static long go(long l) {
		long ans = 0;
		for(long t : tree) {
			if(t > l) {
				ans += (t - l);
			}
		}
		return ans;
	}

}
