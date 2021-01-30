package bf9;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static boolean[] check = new boolean[26];
	static int[][] board;
	static int max = -1;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			board = new int[R][C];
			
			for(int i = 0; i < R; i++) {
				String input = br.readLine();
				for(int j = 0; j < C; j++) {
					board[i][j] = input.charAt(j) - 'A';
				}
			}
			
			check[board[0][0]] = true;
			go(0, 0, 1);
			System.out.println(max);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void go(int r, int c, int num) {
		if(num > max) {
			max = num;
		}
		for(int i = 0; i < 4; i++) {
			int next_r = r + dy[i];
			int next_c = c + dx[i];
			if(next_r < 0 || next_c < 0 || next_r >= R || next_c >= C)
				continue;
			if(check[board[next_r][next_c]])
				continue;
			check[board[next_r][next_c]] = true;
			go(next_r, next_c, num + 1);
			check[board[next_r][next_c]] = false;
		}
	}

}
