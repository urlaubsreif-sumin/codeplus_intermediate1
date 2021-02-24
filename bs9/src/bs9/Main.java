package bs9;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] seq;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			seq = new int[N];
			int min = -1;
			int max = -1;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				seq[i] = Integer.parseInt(st.nextToken());
				min = min == -1 || min > seq[i] ? seq[i] : min;
				max = max == -1 || max < seq[i] ? seq[i] : max;
			}
			
			int start = 0;
			int end = max - min;
			int ans = 0;
			
			//미리 정답(최대값의 최소값)을 구해놓고, 정답에 맞게 최대한 구간을 많이 끊는다.
			//끊어진 구간이 M보다 많은 경우 -> 정답을 더 크게 정한다.
			//끊어진 구간이 M보다 작은 경우 -> 정답을 더 작게 정한다.
			while(start <= end) {
				int mid = (start + end) / 2;
				int res = go(mid);
				if(res >= M) {
					start = mid + 1;
				}
				else {
					end = mid - 1;
					ans = mid;
				}
			}
			
			System.out.println(ans);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int go(int n) {
		int part = 0;
		int min = seq[0];
		int max = seq[0];
		
		for(int i = 1; i < N; i++) {
			if(seq[i] > max) max = seq[i];
			if(seq[i] < min) min = seq[i];
			if(max - min > n) {
				part++;
				min = seq[i];
				max = seq[i];
			}
		}
		return part;
		
	}

}
