package greedy6;
import java.io.*;

public class Main {
	static int N;
	static char[][] init;
	static char[][] coins;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			coins = new char[N][N];
			init = new char[N][N];
			
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < N; j++) {
					init[i][j] = input.charAt(j);
					coins[i][j] = input.charAt(j);
				}
			}
			
			go();
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void go() {
		int min = N * N;
		for(int i = 0; i < (1 << N); i++) {
			int c = 0;
			for(int j = 0; j < N; j++) {
				if(((1 << j) & i) != 0) {
					flip(j);
				}
			}
			c = count();
			if(min > c) {
				min = c;
			}
			copy();
		}
		System.out.println(min);
	}
	
	public static void flip(int j) {
		for(int i = 0; i < N; i++) {
			if(coins[j][i] == 'H')
				coins[j][i] = 'T';
			else
				coins[j][i] = 'H';
		}
	}
	
	public static void copy() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				coins[i][j] = init[i][j];
			}
		}
	}
	
	public static int count() {
		int ans = 0;
		for(int j = 0; j < N; j++) {
			int H = 0;
			int T = 0;
			for(int i = 0; i < N; i++) {
				if(coins[i][j] == 'H') H++;
				else T++;
			}
			ans = H > T ? ans + T : ans + H;
		}
		return ans;
	}
}
