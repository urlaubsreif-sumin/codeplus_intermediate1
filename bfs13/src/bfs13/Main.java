package bfs13;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] prime = new boolean[10000];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		prime[0] = true;
		prime[1] = true;
		
		try {
			int T = Integer.parseInt(br.readLine());
			find_prime();
			
			while(T --> 0) {
				st = new StringTokenizer(br.readLine());
				int N1 = Integer.parseInt(st.nextToken());
				int N2 = Integer.parseInt(st.nextToken());
				
				bfs(N1, N2);
			}
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void find_prime() {
		for(int i = 2; i < 100; i++) {
			if(!prime[i]) {
				for(int j = i * 2; j < 10000; j += i) {
					prime[j] = true;
				}
			}
		}
	}
	
	public static void bfs(int n1, int n2) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] check = new int[10000];
		queue.add(n1);
		check[n1] = 1;
		while(!queue.isEmpty()) {
			int cur = queue.remove();
			if(cur == n2) {
				sb.append(check[cur] - 1).append('\n');
				return;
			}
			for(int next = 1000; next < 10000; next++) {
				if(check[next] != 0) {
					continue;
				}
				if(!prime[next] && valid(cur, next)) {
					queue.add(next);
					check[next] = check[cur] + 1;
				}
			}
		}
		sb.append("Impossible");
		return;
	}
	
	public static boolean valid(int n1, int n2) {
		int k = 1;
		for(int i = 0; i < 4; i++) {
			if(n1 % 10 - n2 % 10 != 0) {
				k--;
			}
			if(k < 0) {
				return false;
			}
			n1 /= 10;
			n2 /= 10;
		}
		return true;
	}
}
