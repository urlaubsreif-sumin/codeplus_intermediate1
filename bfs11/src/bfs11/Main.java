package bfs11;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int di = 0;
	static int dj = 0;
	static int si = 0;
	static int sj = 0;
	static char[][] map;
	static int[][] check;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new char[R][C];
			check = new int[R][C];
			
			for(int i = 0; i < R; i++) {
				String input = br.readLine();
				for(int j = 0; j < C; j++) {
					map[i][j] = input.charAt(j);
					check[i][j] = -1;
					if(map[i][j] == 'D') {
						di = i;
						dj = j;
						check[i][j] = -2;
					}
					else if(map[i][j] == 'S') {
						si = i;
						sj = j;
					}
					else if(map[i][j] == '*') {
						check[i][j] = 0;
					}
					else if(map[i][j] == 'X') {
						check[i][j] = -2;
					}
				}
			}
			
			fill_water();
			move();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void fill_water() {
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(check[i][j] == 0) {
					queue.add(i);
					queue.add(j);
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int cur_i = queue.remove();
			int cur_j = queue.remove();
			for(int i = 0; i < 4; i++) {
				int next_i = cur_i + dy[i];
				int next_j = cur_j + dx[i];
				if(next_i < 0 || next_j < 0 || next_i >= R || next_j >= C)
					continue;
				if(check[next_i][next_j] == -1) {
					queue.add(next_i);
					queue.add(next_j);
					check[next_i][next_j] = check[cur_i][cur_j] + 1;
				}
			}
		}
	}
	
	public static void move() {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[][] time = new int[R][C];
		int cur_i = si;
		int cur_j = sj;
		queue.add(cur_i);
		queue.add(cur_j);
		time[cur_i][cur_j] = 1;
		while(!queue.isEmpty()) {
			cur_i = queue.remove();
			cur_j = queue.remove();
			for(int i = 0; i < 4; i++) {
				int next_i = cur_i + dy[i];
				int next_j = cur_j + dx[i];
				if(next_i < 0 || next_j < 0 || next_i >= R || next_j >= C)
					continue;
				if(time[next_i][next_j] != 0)
					continue;
				if(next_i == di && next_j == dj) {
					System.out.println(time[cur_i][cur_j]);
					return;					
				}
				if(check[next_i][next_j] == -2)
					continue;
				if(check[next_i][next_j] == -1 || time[cur_i][cur_j] < check[next_i][next_j]) {
					queue.add(next_i);
					queue.add(next_j);
					time[next_i][next_j] = time[cur_i][cur_j] + 1;
				}
			}
		}
		System.out.println("KAKTUS");
	}

}
