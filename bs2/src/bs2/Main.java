package bs2;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] lan;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int K = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			lan = new int[K];
			long max = 1;
			for(int i = 0; i < K; i++) {
				lan[i] = Integer.parseInt(br.readLine());
				if(lan[i] > max)
					max = lan[i];
			}
			
			long start = 1;
			long end = max;
			int ans = 0;
			
			while(start <= end) {
				int mid = (int)((start + end) / 2L);
				long res = go(mid);
				if(res < N) {
					end = mid - 1;
				}
				else if(res >= N) {
					start = ((long)mid + 1);
					ans = (int)mid;
				}
			}
			
			System.out.println(ans);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static long go(int l) {
		long ans = 0;
		for(int i = 0; i < lan.length; i++) {
			ans += (long)(lan[i] / l);
		}
		return ans;
	}

}
