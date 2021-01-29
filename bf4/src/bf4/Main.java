package bf4;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static int N;
	static int M;
	static char[][] board;
	static int min = -1;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new char[N][M];
			int cnt = 0;
			int ci1 = 0, cj1 = 0, ci2 = 0, cj2 = 0;
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < M; j++) {
					char ch = input.charAt(j);
					if(ch == 'o' && cnt == 0) {
						ci1 = i;
						cj1 = j;
						cnt++;
					}
					else if(ch == 'o' && cnt == 1) {
						ci2 = i;
						cj2 = j;
					}
					board[i][j] = input.charAt(j);
				}
			}
			
			go(0, ci1, cj1, ci2, cj2);
			
			System.out.println(min);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void go(int num, int ci1, int cj1, int ci2, int cj2) {
		if(num > 10) {
			return;
		}
		//둘 다 떨어진 경우
		if(fall(ci1, cj1) && fall(ci2, cj2)) return;
		//둘 중 하나만 떨어진 경우
		else if(fall(ci1, cj1) || fall(ci2, cj2)) {
			if(min == -1 || num < min) {
				min = num;
			}
			return;
		}
		//아직 떨어지지 않은 경우
		for(int i = 0; i < 4; i++) {
			int ni1 = ci1 + dy[i];
			int nj1 = cj1 + dx[i];
			int ni2 = ci2 + dy[i];
			int nj2 = cj2 + dx[i];
			if(!fall(ni1, nj1) && board[ni1][nj1] == '#') {
				ni1 = ci1;
				nj1 = cj1;
			}
			if(!fall(ni2, nj2) && board[ni2][nj2] == '#') {
				ni2 = ci2;
				nj2 = cj2;
			}
			if(ni1 == ci1 && nj1 == cj1 && ni2 == ci2 && nj2 == cj2) {
				continue;
			}
			go(num + 1, ni1, nj1, ni2, nj2);
		}
	}
	
	public static boolean fall(int i, int j) {
		if(i < 0 || i >= N) {
			return true;
		}
		if(j < 0 || j >= M) {
			return true;
		}
		return false;
	}
}