package greedy4;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] A;
	static int[][] B;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			A = new int[N][M];
			B = new int[N][M];
			boolean same = true;
			int ans = 0;
			
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < M; j++) {
					A[i][j] = input.charAt(j) - '0';
				}
			}
			
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < M; j++) {
					B[i][j] = input.charAt(j) - '0';
					if(B[i][j] != A[i][j]) {
						same = false;
					}
				}
			}
			if(same) {
				System.out.println(0);
				return;
			}
			
			if(N < 3 || M < 3) {
				System.out.println(-1);
				return;
			}
			
			for(int i = 0; i < N - 2; i++) {
				for(int j = 0; j < M - 2; j++) {
					if(A[i][j] != B[i][j]) {
						flip(i, j);
						ans++;
					}
				}
			}
			
			for(int i = N - 2; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(A[i][j] != B[i][j]) {
						System.out.println(-1);
						return;
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = M - 2; j < M; j++) {
					if(A[i][j] != B[i][j]) {
						System.out.println(-1);
						return;
					}
				}
			}
			
			System.out.println(ans);
			return;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void flip(int r, int c) {
		for(int i = r; i < r + 3; i++) {
			for(int j = c; j < c + 3; j++) {
				if(A[i][j] == 0)
					A[i][j] = 1;
				else
					A[i][j] = 0;
			}
		}
	}

}
