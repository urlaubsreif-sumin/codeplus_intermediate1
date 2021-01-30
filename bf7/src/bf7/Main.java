package bf7;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] sudoku = new int[9][9];
	static boolean[][] check_row = new boolean[9][9];
	static boolean[][] check_col = new boolean[9][9];
	static boolean[][] check_sq = new boolean[9][9];
	static boolean state;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			for(int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 9; j++) {
					int n = Integer.parseInt(st.nextToken()) - 1;
					sudoku[i][j] = n;
					if(n >= 0) {
						check_row[i][n] = true;
						check_col[j][n] = true;
						check_sq[i / 3 * 3 + j / 3][n] = true;
					}
				}
			}
			
			go(0, 0);
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
			
		} catch (IOException e) {
				e.printStackTrace();			
		}

	}
	
	public static void go(int r, int c) {
		if(state) {
			return;
		}
		if(r == 9) {
			print();
			state = true;
			return;
		}
		if(sudoku[r][c] != -1) {
			c = c + 1;
			go(r + c / 9, c % 9);
			return;
		}
		for(int k = 0; k < 9; k++) {
			if(check_row[r][k] || check_col[c][k] || check_sq[r / 3 * 3 + c / 3][k]) {
				continue;
			}
			check_row[r][k] = true;
			check_col[c][k] = true;
			check_sq[r / 3 * 3 + c / 3][k] = true;
			sudoku[r][c] = k;
			c = c + 1;
			go(r + c / 9, c % 9);
			c = c - 1;
			sudoku[r][c] = -1;
			check_row[r][k] = false;
			check_col[c][k] = false;
			check_sq[r / 3 * 3 + c / 3][k] = false;
		}
	}
	
	public static void print() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sb.append(sudoku[i][j] + 1).append(' ');
			}
			sb.append('\n');
		}
	}

}
