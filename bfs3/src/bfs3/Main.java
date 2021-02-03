package bfs3;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[] method = new char[10000];
	static int[] check = new int[10000];
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			int T = Integer.parseInt(br.readLine());
			while(T --> 0) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				bfs(A, B);
				
				method = new char[10000];
				check = new int[10000];
			}
			//System.out.println(sb);
			//br.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void bfs(int A, int B) {
		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		int cur = A;
		queue.add(cur);
		check[cur] = 1;
		method[cur] = '0';
		
		while(!queue.isEmpty()) {
			cur = queue.remove();
			if(cur == B) {
				//int idx = sb.length();
				while(cur != A) {
					sb.append(method[cur]);
					//sb.insert(idx, method[cur]);
					cur = check[cur];
				}
				//sb.append('\n');
				System.out.println(sb.reverse());
				return;
			}
			int next = cur * 2 % 10000;
			if(check[next] == 0) {
				queue.add(next);
				check[next] = cur;
				method[next] = 'D';
			}
			
			next = cur - 1;
			if(next < 0) {
				next = 9999;
			}
			if(check[next] == 0) {
				queue.add(next);
				check[next] = cur;
				method[next] = 'S';
			}
			next = (cur % 1000 * 10) + (cur / 1000);
			if(check[next] == 0) {
				queue.add(next);
				check[next] = cur;
				method[next] = 'L';
			}
			
			next = cur % 10 * 1000 + cur / 10;
			if(check[next] == 0) {
				queue.add(next);
				check[next] = cur;
				method[next] = 'R';
			}
		}
		
	}
}
