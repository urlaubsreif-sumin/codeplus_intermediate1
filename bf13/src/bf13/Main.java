package bf13;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] board;
	static int[][] init;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			init = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					init[i][j] = board[i][j];
				}
			}
			
			int[] move = new int[5];
			int res = 0;
			for(int i = 0; i < (1 << 10); i++) {
				move = gen(i);
				int tmp = go(move);
				res = res > tmp ? res : tmp;
				
				copy();
			}
			
			System.out.println(res);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int[] gen(int k) {
		int[] res = new int[5];
		for(int i = 0; i < 5; i++) {
			res[i] = (k & 3);
			k >>= 2;
		}
		return res;
	}
	
	public static void copy(){
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				board[i][j] = init[i][j];
			}
		}
	}
	
	public static int go(int[] move) {
		for(int dir : move) {
			switch(dir) {
			case 0:
				up();
				break;
			case 1:
				down();
				break;
			case 2:
				left();
				break;
			case 3:
				right();
				break;
			}
		}
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				max = board[i][j] > max ? board[i][j] : max;
			}
		}
		return max;
	}
	
	public static void up() {
		boolean change = true;
		boolean[][] merged = new boolean[N][N];
		while(change) {
			change = false;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int next_i = i - 1;
					int next_j = j;
					if(next_i < 0)
						continue;
					if(board[i][j] == 0)
						continue;
					if(board[next_i][next_j] == 0) {
						board[next_i][next_j] = board[i][j];
						merged[next_i][next_j] = merged[i][j];
						board[i][j] = 0;
						change = true;
					}
					else if(board[next_i][next_j] == board[i][j]) {
						if(!merged[next_i][next_j] && !merged[i][j]) {
							board[next_i][next_j] *= 2;
							merged[next_i][next_j] = true;
							board[i][j] = 0;
							change = true;
						}
					}
				}
			}
		}
		
	}
	
	public static void down() {
		boolean change = true;
		boolean[][] merged = new boolean[N][N];
		while(change) {
			change = false;
			for(int i = N - 1; i >= 0; i--) {
				for(int j = N - 1; j >= 0; j--) {
					int next_i = i + 1;
					int next_j = j;
					if(next_i >= N)
						continue;
					if(board[i][j] == 0)
						continue;
					if(board[next_i][next_j] == 0) {
						board[next_i][next_j] = board[i][j];
						merged[next_i][next_j] = merged[i][j];
						board[i][j] = 0;
						change = true;
					}
					else if(board[next_i][next_j] == board[i][j]) {
						if(!merged[next_i][next_j] && !merged[i][j]) {
							board[next_i][next_j] *= 2;
							merged[next_i][next_j] = true;
							board[i][j] = 0;
							change = true;
						}
					}
				}
			}
		}
		
	}
	
	public static void left() {
		boolean change = true;
		boolean[][] merged = new boolean[N][N];
		while(change) {
			change = false;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int next_i = i;
					int next_j = j - 1;
					if(next_j < 0)
						continue;
					if(board[i][j] == 0)
						continue;
					if(board[next_i][next_j] == 0) {
						board[next_i][next_j] = board[i][j];
						merged[next_i][next_j] = merged[i][j];
						board[i][j] = 0;
						change = true;
					}
					else if(board[next_i][next_j] == board[i][j]) {
						if(!merged[next_i][next_j] && !merged[i][j]) {
							board[next_i][next_j] *= 2;
							merged[next_i][next_j] = true;
							board[i][j] = 0;
							change = true;
						}
					}
				}
			}
		}
		
	}
	
	public static void right() {
		boolean change = true;
		boolean[][] merged = new boolean[N][N];
		while(change) {
			change = false;
			for(int i = N - 1; i >= 0; i--) {
				for(int j = N - 1; j >= 0; j--) {
					int next_i = i;
					int next_j = j + 1;
					if(next_j >= N)
						continue;
					if(board[i][j] == 0)
						continue;
					if(board[next_i][next_j] == 0) {
						board[next_i][next_j] = board[i][j];
						merged[next_i][next_j] = merged[i][j];
						board[i][j] = 0;
						change = true;
					}
					else if(board[next_i][next_j] == board[i][j]) {
						if(!merged[next_i][next_j] && !merged[i][j]) {
							board[next_i][next_j] *= 2;
							merged[next_i][next_j] = true;
							board[i][j] = 0;
							change = true;
						}
					}
				}
			}
		}
		
	}

}
