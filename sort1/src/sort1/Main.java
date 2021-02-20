package sort1;
import java.io.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			int[] res = sort(0, N - 1);
			
			for(int i = 0; i < N; i++) {
				sb.append(res[i]).append('\n');
			}
			
			System.out.println(sb.toString());
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int[] sort(int s, int e) {
		if(e - s == 0) {
			int[] res = {arr[e]};
			return res;
		}
		
		int m = (s + e) / 2;
		
		int[] left = sort(s, m);
		int[] right = sort(m + 1, e);
		int[] res = merge(left, right);
		return res;
	}
	
	public static int[] merge(int[] left, int[] right) {
		int l = 0;
		int r = 0;
		int i = 0;
		int[] res = new int[left.length + right.length];
		while(r < right.length) {
			if(l >= left.length) {
				res[i++] = right[r++];
			}
			else if(left[l] < right[r]) {
				res[i++] = left[l++];
			}
			else if(left[l] >= right[r]) {
				res[i++] = right[r++];
			}
		}
		while(l < left.length) {
			res[i++] = left[l++];
		}
		return res;
	}
}
