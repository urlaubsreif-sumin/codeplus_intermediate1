package bs11;
import java.io.*;

public class Main {
	static int n;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			n = Integer.parseInt(br.readLine());
			long k = Long.parseLong(br.readLine());
			
			long start = 1;
			long end = (long)n * (long)n;
			long ans = 0;
			
			while(start <= end) {
				long mid = (long)((start + end) / 2);
				long res = last(mid);
				if(res < k) {
					start = mid + 1;
				}
				else {
					end = mid - 1;
					ans = mid;
				}
			}
			
			System.out.println(ans);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static long last(long mid) {
		long cnt = 0;
		for(int i = 1; i < n + 1; i++) {
			cnt += (long)Math.min(n, mid / i);
		}
		return cnt;
	}
}
