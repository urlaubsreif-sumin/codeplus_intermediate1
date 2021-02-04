package bfs7;
import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] check;
	static int[] count;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			check = new int[N][M];
			count = new int[N * M / 2 + 2];
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < M; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			
			int num = grouping();
			go(num);
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int grouping() {
		int num = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0 && check[i][j] == 0) {
					bfs(i, j, num);
					num++;
				}
			}
		}
		return num;
	}
	
	public static void bfs(int si, int sj, int num) {
		Queue<Integer> queue = new LinkedList<>();
		int cur_i = si;
		int cur_j = sj;
		queue.add(cur_i);
		queue.add(cur_j);
		check[cur_i][cur_j] = num;
		int c = 1;
		while(!queue.isEmpty()) {
			cur_i = queue.remove();
			cur_j = queue.remove();
			for(int i = 0; i < 4; i++) {
				int next_i = cur_i + dy[i];
				int next_j = cur_j + dx[i];
				if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= M)
					continue;
				if(check[next_i][next_j] != 0)
					continue;
				if(map[next_i][next_j] == 0) {
					check[next_i][next_j] = num;
					c++;
					c %= 10;
					queue.add(next_i);
					queue.add(next_j);
				}
			}
		}
		count[num] = c;
	}
	
	public static void go(int num) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					HashSet<Integer> hash = new HashSet<>();
					for(int k = 0; k < 4; k++) {
						int next_i = i + dy[k];
						int next_j = j + dx[k];
						if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= M)
							continue;
						int group = check[next_i][next_j];
						hash.add(group);
					}
					int ans = 1;
					for(int h : hash) {
						ans += count[h];
					}
					sb.append(ans % 10);
				}
				else {
					sb.append(0);
				}
			}
			sb.append('\n');
		}
	}

}
