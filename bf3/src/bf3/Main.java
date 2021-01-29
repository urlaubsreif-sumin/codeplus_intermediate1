package bf3;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static int[] num;
	static int N;
	static int max;
	static int min;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			num = new int[N];
			max = -1000000000;
			min = 1000000000;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] op = new int[4];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			
			calc(num[0], 1, op);
			
			System.out.println(max);
			System.out.println(min);
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void calc(int res, int idx, int[] op) {
		if(idx >= N) {
			if(max < res) {
				max = res;
			}
			if(min > res) {
				min = res;
			}
			return;
		}
		if(op[0] > 0) {
			op[0]--;
			calc(res + num[idx], idx + 1, op);
			op[0]++;
		}
		if(op[1] > 0) {
			op[1]--;
			calc(res - num[idx], idx + 1, op);
			op[1]++;
		}
		if(op[2] > 0) {
			op[2]--;
			calc(res * num[idx], idx + 1, op);
			op[2]++;
		}
		if(op[3] > 0) {
			op[3]--;
			calc(res / num[idx], idx + 1, op);
			op[3]++;
		}
	}
}
