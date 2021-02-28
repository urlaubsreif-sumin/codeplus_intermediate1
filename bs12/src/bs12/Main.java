package bs12;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] time;
	static int M;
	static long N;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Long.parseLong(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			time = new int[M];
			
			st = new StringTokenizer(br.readLine());
			
			
			for(int i = 0; i < M; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			//인원수가 놀이기구 수 보다 적을 경우
			if(N <= M) {
				System.out.println(N);
				return;
			}
			
			long start = 0;
			long end = 30 * N;
			long ans = 0;
			long res = 0;
			while(start <= end) {
				long mid = (start + end) / 2L;
				long l = last(mid);
				long f = last(mid - 1) + 1;
				if(f <= N && N <= l) {
					ans = mid;
					f--;
					for(int i = 1; i < M + 1; i++) {
						if(ans % time[i - 1] == 0) {
							f++;
						}
						if(f == N) {
							System.out.println(i);
							return;
						}
					}
				}
				else if(f > N) {
					end = mid - 1;
				}
				else if(l < N){
					start = mid + 1;
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static long last(long mid) {
		long cnt = M;
		for(int i = 1; i < M + 1; i++) {
			cnt += (long)(mid / time[i - 1]);
		}
		return cnt;
	}
}
