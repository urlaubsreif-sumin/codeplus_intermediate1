package greedy9;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] sequence;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			sequence = new int[N];
			st = new StringTokenizer(br.readLine());
			int max = 0;
			
			for(int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				int len = go(num, max);
				if(len == max) {
					max++;
				}
			}
			
			System.out.println(max);
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int go(int num, int max) {
		int start = 0;
		while(start < max && sequence[start] < num) {
			start++;
		}
		sequence[start] = num;
		return start;
	}

}
