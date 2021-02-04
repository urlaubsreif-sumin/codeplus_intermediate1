package bfs6;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][][] check;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			check = new int[N][M][2];
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < M; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			
			int res = bfs();
			System.out.println(res);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int bfs() {
		Queue<Result> queue = new LinkedList<Result>();
		int cur_i = 0;
		int cur_j = 0;
		int broken = 0;
		queue.add(new Result(cur_i, cur_j, 0));
		check[cur_i][cur_j][0] = 1;
		while(!queue.isEmpty()) {
			Result cur = queue.remove();
			cur_i = cur.i;
			cur_j = cur.j;
			broken = cur.broken;
			if(cur_i == N - 1 && cur_j == M - 1) {
				return check[cur_i][cur_j][broken];
			}
			for(int i = 0; i < 4; i++) {
				int next_i = cur_i + dy[i];
				int next_j = cur_j + dx[i];
				if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= M)
					continue;
				if(map[next_i][next_j] == 1) {
					if(check[next_i][next_j][1] != 0)
						continue;
					if(broken == 0) {
						queue.add(new Result(next_i, next_j, 1));
						check[next_i][next_j][1] = check[cur_i][cur_j][broken] + 1;
					}
				}
				else {
					if(check[next_i][next_j][broken] != 0)
						continue;
					queue.add(new Result(next_i, next_j, broken));
					check[next_i][next_j][broken] = check[cur_i][cur_j][broken] + 1;
				}
			}

		}
		return -1;
	}

}

class Result {
	int i, j;
	int broken;
	Result(int i, int j, int broken){
		this.i = i;
		this.j = j;
		this.broken = broken;
	}
}
