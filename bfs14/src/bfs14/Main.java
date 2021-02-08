package bfs14;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[][] pic;
	static int[][] normal_check;
	static int[][] blind_check;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			N = Integer.parseInt(br.readLine());
			pic = new char[N][N];
			normal_check = new int[N][N];
			blind_check = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < N; j++) {
					pic[i][j] = input.charAt(j);
				}
			}
			
			go();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void go() {
		int nn = 1;
		int bn = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(normal_check[i][j] == 0) {
					bfs(i, j, nn);
					nn++;
				}
				if(blind_check[i][j] == 0) {
					blind_bfs(i, j, bn);
					bn++;
				}
			}
		}
		
		nn--;
		bn--;
		
		System.out.println(nn + " " + bn);
	}
	
	public static void bfs(int si, int sj, int num) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int cur_i = si;
		int cur_j = sj;
		normal_check[cur_i][cur_j] = num;
		queue.add(cur_i);
		queue.add(cur_j);
		
		while(!queue.isEmpty()) {
			cur_i = queue.remove();
			cur_j = queue.remove();
			for(int i = 0; i < 4; i++) {
				int next_i = cur_i + dy[i];
				int next_j = cur_j + dx[i];
				if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= N)
					continue;
				if(normal_check[next_i][next_j] != 0)
					continue;
				if(pic[next_i][next_j] == pic[cur_i][cur_j]) {
					queue.add(next_i);
					queue.add(next_j);
					normal_check[next_i][next_j] = num;
				}
			}
		}
		
	}
	
	public static void blind_bfs(int si, int sj, int num) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int cur_i = si;
		int cur_j = sj;
		blind_check[cur_i][cur_j] = num;
		queue.add(cur_i);
		queue.add(cur_j);
		
		while(!queue.isEmpty()) {
			cur_i = queue.remove();
			cur_j = queue.remove();
			for(int i = 0; i < 4; i++) {
				int next_i = cur_i + dy[i];
				int next_j = cur_j + dx[i];
				if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= N)
					continue;
				if(blind_check[next_i][next_j] != 0)
					continue;
				if((pic[next_i][next_j] == 'R' && pic[cur_i][cur_j] == 'G') 
						|| (pic[next_i][next_j] == 'G' && pic[cur_i][cur_j] == 'R')) {
					queue.add(next_i);
					queue.add(next_j);
					blind_check[next_i][next_j] = num;
				}
				else if(pic[next_i][next_j] == pic[cur_i][cur_j]) {
					queue.add(next_i);
					queue.add(next_j);
					blind_check[next_i][next_j] = num;
				}
			}
		}
		
	}

}
