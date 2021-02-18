package dc9;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] ans;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine());
			ans = new int[N][N];
						
			go(N, 0, 0);
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(ans[i][j] == 1) {
						sb.append("*");
					}
					else {
						sb.append(" ");
					}
				}
				sb.append("\n");
			}
			
			System.out.println(sb.toString());
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void go(int n, int i, int j) {
		if(n == 3) {
			for(int r = i; r < i + 3; r++) {
				for(int c = j; c < j + 3; c++) {
					if(r != i + 1 || c != j + 1) {
						ans[r][c] = 1;
					}
				}
			}
			return;
		}
		go(n / 3, i, j);
		go(n / 3, i + n / 3, j);
		go(n / 3, i + 2 * n / 3, j);
		
		go(n / 3, i, j + n / 3);
		go(n / 3, i + 2 * n / 3, j + n / 3);
		
		go(n / 3, i, j + 2 * n / 3);
		go(n / 3, i + n / 3, j + 2 * n / 3);
		go(n / 3, i + 2 * n / 3, j + 2 * n / 3);
		
	}
}
