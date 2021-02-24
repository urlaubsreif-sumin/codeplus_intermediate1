package bs8;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] lesson;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			lesson = new int[N];
			
			int sum = 0;
			int min = -1;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				lesson[i] = Integer.parseInt(st.nextToken());
				sum += lesson[i];
				if(min == -1 || min > lesson[i]) {
					min = lesson[i];
				}
			}
			
			int start = min;
			int end = sum;
			int ans = 0;
			
			while(start <= end) {
				int mid = (start + end) / 2;
				if(go(mid)) {
					end = mid - 1;
					ans = mid;
				}
				else {
					start = mid + 1;
				}
			}
			
			System.out.println(ans);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static boolean go(int len) {
		int num = M - 1;
		int idx = 0;
		int cur = len;
		while(num >= 0) {
			if(cur >= lesson[idx]) {
				cur -= lesson[idx];
			}
			else {
				num--;
				cur = len - lesson[idx];
				if(cur < 0) {
					return false;
				}
			}
			idx++;
			if(num >= 0 && idx >= N) {
				return true;
			}
		}
		return false;
	}

}
