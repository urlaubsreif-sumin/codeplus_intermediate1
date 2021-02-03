package bfs1;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] next;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			next = new int[101];
			for(int i = 0; i < 101; i++) {
				next[i] = i;
			}
			
			for(int i = 0; i < N + M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				next[from] = to;
			}
			
			int res = bfs();
			System.out.println(res);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] check = new int[101];
		int cur = 1;
		queue.add(cur);
		check[cur] = 1;
		
		while(!queue.isEmpty()) {
			cur = queue.remove();
			if(cur == 100) {
				return check[cur] - 1;
			}
			for(int i = 1; i < 7; i++) {
				if(cur + i > 100)
					continue;
				int n = next[cur + i];
				if(check[n] != 0)
					continue;
				queue.add(n);
				check[n] = check[cur] + 1;
			}
		}
		return -1;
	}

}
