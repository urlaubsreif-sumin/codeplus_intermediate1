package greedy15;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int a = 0;
			int b = 0;
			boolean find = false;
			
			if(K == 0) {
				for(int i = 0; i < N; i++) {
					sb.append('A');
				}
				System.out.println(sb.toString());
				return;
			}
			
			for(a = 1; a < N; a++) {
				b = N - a;
				if(a * b < K)
					continue;
				while(b > 0) {
					if(b <= K) {
						sb.append('A');
						K -= b;
					}
					else {
						sb.append('B');
						b--;
					}
				}
				find = true;
				break;
			}
			
			if(!find) {
				sb.append(-1);
			}
			
			
			System.out.println(sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
