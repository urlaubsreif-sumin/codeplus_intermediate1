package bfs10;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][] chess;
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1, 0};

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		chess = new char[8][8];
				
			try {
				for(int i = 0; i < 8; i++) {
					String input;
					input = br.readLine();
					for(int j = 0; j < 8; j++) {
						chess[i][j] = input.charAt(j);
					}
				}
				
				bfs();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public static void bfs() {
		Queue<Result> queue = new LinkedList<>();
		boolean check[][] = new boolean[8][8];

		Result cur = new Result(7, 0, 0);
		check[cur.i][cur.j] = true;
		queue.add(cur);
		while(!queue.isEmpty()) {
			cur = queue.remove();
			if(cur.i == 0 && cur.j == 7) {
				System.out.println(1);
				return;
			}
			for(int i = 0; i < 9; i++) {
				int next_i = cur.i + dy[i];
				int next_j = cur.j + dx[i];
				int time = Math.min(cur.time + 1, 8);
				if(next_i < 0 || next_j < 0 || next_i >= 8 || next_j >= 8)
					continue;
				if(next_i - cur.time - 1 >= 0 && chess[next_i - cur.time - 1][next_j] == '#')
					continue;
				if(next_i - cur.time >= 0 && chess[next_i - cur.time][next_j] == '#')
					continue;
				if(!check[next_i][next_j] || (next_i == cur.i && next_j == cur.j)) {
					queue.add(new Result(next_i, next_j, time));
					check[next_i][next_j] = true;
				}
			}
		}
		System.out.println(0);
	}
}

class Result {
	int i, j;
	int time;
	Result(int i, int j, int time){
		this.i = i;
		this.j = j;
		this.time = time;
	}
}
