package greedy12;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int team = 0;
			
			if(N >= M * 2) {
				team = M;
				N -= (team * 2);
				M -= team;
			}
			else if(N < M * 2) {
				team = N / 2;
				M -= team;
				N -= (team * 2);
			}
			
			K -= (N + M);
			
			if(K > 0) {
				team -= ((K - 1) / 3 + 1);
			}
			
			System.out.println(team);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
