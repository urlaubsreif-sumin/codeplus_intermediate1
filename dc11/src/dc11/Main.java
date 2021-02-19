package dc11;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static long swap = 0;
	static int[] seq;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			int N = Integer.parseInt(br.readLine());
			seq = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				seq[i] = Integer.parseInt(st.nextToken());
			}
			
			go(0, N - 1);
			
			System.out.println(swap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void go(int s, int e) {
		if(s >= e)
			return;
		int n = e - s + 1;
		go(s, s + n / 2 - 1);
		go(s + n / 2, e);
		
		int left = s;
		int right = s + n / 2;
		int[] res = new int[n];
		int idx = 0;
		while(right <= e) {
			if(seq[left] <= seq[right]) {
				res[idx++] = seq[left++];
			}
			else {
				swap += (s + n / 2 - left);
				res[idx++] = seq[right++];
			}
			if(left > s + n / 2 - 1) {
				while(right <= e) {
					res[idx++] = seq[right++];
				}
			}
		}
		
		while(left <= s + n / 2 - 1) {
			res[idx++] = seq[left++];
		}
		
		for(int i = s; i <= e; i++) {
			seq[i] = res[i - s];
		}
	}
}
