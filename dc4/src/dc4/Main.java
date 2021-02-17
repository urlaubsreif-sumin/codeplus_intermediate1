package dc4;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] paper;
	static int[] result;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		try {
			N = Integer.parseInt(br.readLine());
			paper = new int[N][N];
			result = new int[3];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					paper[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			go(N, 0, 0);
			
			for(int i : result) {
				sb.append(i).append(' ');
			}
			
			System.out.println(sb.toString());
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void go(int n, int x, int y) {
		int k = paper[y][x];
		if(n == 1) {
			result[k + 1]++;
			return;
		}
		for(int i = y; i < y + n; i++) {
			for(int j = x; j < x + n; j++) {
				if(paper[i][j] != k) {
					int m = n / 3;
					go(m, x, y);
					go(m, x + m, y);
					go(m, x + 2 * m, y);
					go(m, x, y + m);
					go(m, x + m, y + m);
					go(m, x + 2 * m, y + m);
					go(m, x, y + 2 * m);
					go(m, x + m, y + 2 * m);
					go(m, x + 2 * m, y + 2 * m);
					return;
				}
			}
		}
		result[k + 1]++;
	}

}
