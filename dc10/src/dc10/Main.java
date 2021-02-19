package dc10;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static boolean[][] stars;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine());
			stars = new boolean[N][2 * N - 1];
			
			go(N - 1, 0, N);
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < 2 * N - 1; j++) {
					if(stars[i][j]) sb.append("*");
					else sb.append(" ");
				}
				sb.append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void go(int i, int j, int n) {
		if(n == 3) {
			paint(i, j);
		}
		if(n != 3) {
			go(i, j, n / 2);
			go(i - n / 2, j + n / 2, n / 2);
			go(i, j + n, n / 2);
		}
	}
	
	public static void paint(int i, int j) {
		for(int c = j; c < j + 5; c++) {
			stars[i][c] = true;
		}
		stars[i - 1][j + 1] = true;
		stars[i - 1][j + 3] = true;
		stars[i - 2][j + 2] = true;
	}

}
