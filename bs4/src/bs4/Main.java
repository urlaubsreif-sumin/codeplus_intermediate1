package bs4;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[] house;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			house = new long[N];
			
			for(int i = 0; i < N; i++) {
				house[i] = Long.parseLong(br.readLine());
			}
			
			Arrays.sort(house);
			
			long start = 1;
			long end = house[house.length - 1] - house[0];
			long ans = 1;
			
			while(start <= end) {
				long mid = (start + end) / 2L;
				boolean res = go(mid, C);
				if(res) {
					start = mid + 1;
					ans = mid;
				}
				else {
					end = mid - 1;
				}
			}
			
			System.out.println(ans);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean go(long l, int c) {
		long ans = 0;
		long cur = house[0];
		int num = c - 1;
		int idx = 1;
		while(num > 0) {
			if(cur + l <= house[idx]) {
				cur = house[idx];
				idx++;
				num--;
			}
			else {
				idx++;
			}
			if(num > 0 && idx > house.length - 1) {
				return false;
			}
		}
		return true;
	}

}
