package bfs5;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			if((A + B + C) % 3 != 0) {
				System.out.println(0);
				return;
			}
			
			bfs(A, B, C);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
	
	public static void bfs(int A, int B, int C) {
		boolean[][] check = new boolean[1500][1500]; //범위 조심, 500하면 안된다
		Queue<Integer> queue = new LinkedList<>();
		int goal = (A + B + C) / 3;
		int cur_A = A;
		int cur_B = B;
		int cur_C = C;
		queue.add(cur_A);
		queue.add(cur_B);
		queue.add(cur_C);
		
		while(!queue.isEmpty()) {
			cur_A = queue.remove();
			cur_B = queue.remove();
			cur_C = queue.remove();
			if(cur_A == goal && cur_B == goal) {
				System.out.println(1);
				return;
			}
			if(check[cur_A][cur_B]){
				continue;
			}
			check[cur_A][cur_B] = true;
			if(cur_A != goal && cur_B != goal) {
				int next_A = cur_A > cur_B ? cur_A - cur_B : cur_A * 2;
				int next_B = cur_A > cur_B ? cur_B * 2 : cur_B - cur_A;
				int next_C = cur_C;
				queue.add(next_A);
				queue.add(next_B);
				queue.add(next_C);
			}
			if(cur_A != goal && cur_C != goal) {
				int next_A = cur_A > cur_C ? cur_A - cur_C : cur_A * 2;
				int next_B = cur_B;
				int next_C = cur_A > cur_C ? cur_C * 2 : cur_C - cur_A;
				queue.add(next_A);
				queue.add(next_B);
				queue.add(next_C);
			}
			if(cur_B != goal && cur_C != goal) {
				int next_A = cur_A;
				int next_B = cur_B > cur_C ? cur_B - cur_C : cur_B * 2;
				int next_C = cur_B > cur_C ? cur_C * 2 : cur_C - cur_B;
				queue.add(next_A);
				queue.add(next_B);
				queue.add(next_C);
			}
			
		}
		System.out.println(0);
	}
}
