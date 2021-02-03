package bfs2;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			Knight k1 = new Knight(r1, c1);
			
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			Knight k2 = new Knight(r2, c2);
			
			int res = bfs(k1, k2);
			System.out.println(res);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int bfs(Knight k1, Knight k2) {
		Queue<Knight> queue = new LinkedList<Knight>();
		int[][] check = new int[N][N];
		int[] dx = {-1, 1, -2, 2, -1, 1};
		int[] dy = {-2, -2, 0, 0, 2, 2};
		
		queue.add(new Knight(k1.i, k1.j));
		check[k1.i][k1.j] = 1;
		while(!queue.isEmpty()) {
			Knight cur = queue.remove();
			int cur_i = cur.i;
			int cur_j = cur.j;
			if(cur_i == k2.i && cur_j == k2.j) {
				return check[cur_i][cur_j] - 1;
			}
			for(int i = 0; i < 6; i++) {
				int next_i = cur_i + dy[i];
				int next_j = cur_j + dx[i];
				if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= N)
					continue;
				if(check[next_i][next_j] != 0)
					continue;
				queue.add(new Knight(next_i, next_j));
				check[next_i][next_j] = check[cur_i][cur_j] + 1;
			}
		}
		return -1;
	}

}

class Knight {
	int i, j;
	Knight(int i, int j){
		this.i = i;
		this.j = j;
	}
}
