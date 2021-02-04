package bfs4;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = set_wall();
			
			System.out.println(max);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//벽 3개 세우기 - 브루트포스
	public static int set_wall() {
		int max = 0;
		for(int w1i = 0; w1i < N; w1i++) {
			for(int w1j = 0; w1j < M; w1j++) {
				if(map[w1i][w1j] != 0)
					continue;
				for(int w2i = 0; w2i < N; w2i++) {
					for(int w2j = 0; w2j < M; w2j++) {
						if(map[w2i][w2j] != 0)
							continue;
						if(w2i == w1i && w2j == w1j)
							continue;
						for(int w3i = 0; w3i < N; w3i++) {
							for(int w3j = 0; w3j < M; w3j++) {
								if(map[w3i][w3j] != 0)
									continue;
								if(w3i == w1i && w3j == w1j)
									continue;
								if(w2i == w3i && w2j == w3j)
									continue;
								map[w1i][w1j] = 1;
								map[w2i][w2j] = 1;
								map[w3i][w3j] = 1;
								int res = bfs();
								if(max < res) max = res;
								map[w1i][w1j] = 0;
								map[w2i][w2j] = 0;
								map[w3i][w3j] = 0;
								
							}
						}
					}
				}
			}
		}
		return max;
		
	}
	
	//바이러스 퍼뜨리면서 안전지대 수 줄이기
	public static int bfs() {
		boolean[][] check = new boolean[N][M];
		Queue<Integer> queue = new LinkedList<Integer>();
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 2) {
					queue.add(i);
					queue.add(j);
				}
				if(map[i][j] == 0) {
					cnt++;
				}
			}
		}
		while(!queue.isEmpty()) {
			int cur_i = queue.remove();
			int cur_j = queue.remove();
			check[cur_i][cur_j] = true;
			for(int i = 0; i < 4; i++) {
				int next_i = cur_i + dy[i];
				int next_j = cur_j + dx[i];
				if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= M)
					continue;
				if(check[next_i][next_j])
					continue;
				if(map[next_i][next_j] == 0) {
					check[next_i][next_j] = true;
					queue.add(next_i);
					queue.add(next_j);
					cnt--;
				}
			}
		}
		return cnt;
	}
}
