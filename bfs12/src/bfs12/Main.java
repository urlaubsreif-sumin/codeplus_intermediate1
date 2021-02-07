package bfs12;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int[][] map;
	static int[][] check;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			check = new int[R][C];
			int si = -1, sj = -1;
			int ei = -1, ej = -1;
			for(int i = 0; i < R; i++) {
				String input = br.readLine();
				for(int j = 0; j < C; j++) {
					check[i][j] = -1;
					map[i][j] = input.charAt(j);
					if(si == -1 && map[i][j] == 'C') {
						check[i][j] = 0;
						si = i;
						sj = j;
					}
					else if(map[i][j] == 'C') {
						ei = i;
						ej = j;
					}
					if(map[i][j] == '*') {
						check[i][j] = -2;
					}
				}
			}
			
			bfs(si, sj, ei, ej);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void bfs(int si, int sj, int ei, int ej) {
		Queue<Integer> queue = new LinkedList<>();
		int cur_i = si;
		int cur_j = sj;
		int cur_n = check[cur_i][cur_j];
		queue.add(cur_i);
		queue.add(cur_j);
		while(!queue.isEmpty()) {
			cur_i = queue.remove();
			cur_j = queue.remove();
			cur_n = check[cur_i][cur_j];
			if(cur_i == ei && cur_j == ej) {
				System.out.println(check[cur_i][cur_j] - 1);
				return;
			}
			for(int i = 0; i < 4; i++) {
				int next_i = cur_i;
				int next_j = cur_j;
				while(true) {
					next_i = next_i + dy[i];
					next_j = next_j + dx[i];
					if(next_i < 0 || next_j < 0 || next_i >= R || next_j >= C)
						break;
					if(check[next_i][next_j] == -2)
						break;
					if(check[next_i][next_j] == -1) {
						check[next_i][next_j] = cur_n + 1;
						queue.add(next_i);
						queue.add(next_j);
					}
				}
			}
		}
	}
	

}
