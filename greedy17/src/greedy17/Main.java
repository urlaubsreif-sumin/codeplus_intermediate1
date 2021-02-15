package greedy17;
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> temp = new Stack<>();
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			if(N < M + K - 1 || N > M * K) {
				System.out.println(-1);
				return;
			}
			
			int idx = N % K;
			int group = N % K == 0 ? N / K : N / K + 1;
			
			for(int i = 0; i < N; i++) {
				temp.add(i + 1);
				if((i - idx + 1) % K == 0) {
					while(!temp.isEmpty()) {
						sb.append(temp.pop()).append(' ');
					}
				}
				else if(group < M) {
					sb.append(temp.pop()).append(' ');
					group++;
				}
			}
			
			
			System.out.println(sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
