package bs10;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int start = 0;
			int end = 200;
			int ans = 0;
			
			while(start <= end) {
				int mid = (start + end) / 2;
				boolean res = go(mid);
				if(res) {
					end = mid - 1;
					ans = mid;
				}
				else {
					start = mid + 1;
				}
			}
			
			System.out.println(ans);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean go(int mid) {
		for(int i = 0; i + mid <= 200; i++) {
			if(bfs(i, i + mid)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean bfs(int min, int max) {
		boolean[][] check = new boolean[n][n];
		Queue<Integer> queue = new LinkedList<Integer>();
		int cur_i = 0;
		int cur_j = 0;
		if(min > arr[cur_i][cur_j] || max < arr[cur_i][cur_j])
			return false;
		check[cur_i][cur_j] = true;
		queue.add(cur_i);
		queue.add(cur_j);
		
		while(!queue.isEmpty()) {
			cur_i = queue.remove();
			cur_j = queue.remove();
			if(cur_i == n - 1 && cur_j == n - 1) {
				return true;
			}
			for(int i = 0; i < 4; i++) {
				int next_i = cur_i + dy[i];
				int next_j = cur_j + dx[i];
				if(next_i < 0 || next_i >= n || next_j < 0 || next_j >= n)
					continue;
				if(check[next_i][next_j])
					continue;
				if(arr[next_i][next_j] < min || arr[next_i][next_j] > max)
					continue;
				queue.add(next_i);
				queue.add(next_j);
				check[next_i][next_j] = true;
			}
		}
		
		return false;
	}
	
}