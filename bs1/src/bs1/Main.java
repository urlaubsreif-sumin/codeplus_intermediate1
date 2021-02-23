package bs1;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			long k = Long.parseLong(st.nextToken());
			
			if(go(N) < k) {
				System.out.println(-1);
				return;
			}
			
			int start = 1;
			int end = N;
			int ans = 0;
			
			while(start <= end) {
				int mid = (start + end) / 2;
				long res = go(mid);
				if(res == k) {
					ans = mid;
					break;
				}
				if(res < k) {
					start = mid + 1;
				}
				else if(res > k) {
					end = mid - 1;
					ans = mid;
				}
			}
			String num = Integer.toString(ans);
			long idx = go(ans) - k;
			System.out.println(num.charAt((int)(num.length() - idx - 1)));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	//n까지 연결된 수 자리수 구하기
	public static long go(int n) {
		long ans = 0;
		int len = 1;
		for(int k = 1; k <= n; k *= 10) {
			if(n >= k * 10) {
				ans += (long)(k * 9 * len);
				len++;
			}
			else {
				ans += (long)((n - k + 1) * len);
			}
		}
		return ans;
	}
	
	
}
