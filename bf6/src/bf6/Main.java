package bf6;
import java.io.*;

public class Main {
	static boolean[] check_row;
	static boolean[] check_col;
	static boolean[] check_dr;
	static boolean[] check_dl;
	static int N;
	static int ans = 0;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			check_row = new boolean[N];
			check_col = new boolean[N];
			check_dr = new boolean[2 * N - 1];
			check_dl = new boolean[2 * N - 1];
			
			go(0);
			
			System.out.println(ans);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void go(int r) {
		if(r == N) {
			ans++;
			return;
		}
		for(int j = 0; j < N; j++) {
			if(!check_col[j] && !check_dr[r + j] && !check_dl[r - j + N - 1]) {
				check_row[r] = true;
				check_col[j] = true;
				check_dr[r + j] = true;
				check_dl[r - j + N - 1] = true;
				
				go(r + 1);
				
				check_row[r] = false;
				check_col[j] = false;
				check_dr[r + j] = false;
				check_dl[r - j + N - 1] = false;
			}
		}
	}
}
