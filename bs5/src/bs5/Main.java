package bs5;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Pair>[] map;
	static int a, b;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			//간선의 개수가 정점의 개수 ^2보다 못미치는 경우에는 연결리스트를 사용하는 것이 좋다.
			map = (ArrayList<Pair>[]) new ArrayList[N];
			
			for(int i = 0; i < N; i++) {
				map[i] = new ArrayList<Pair>();
			}
			int max = 0;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				int weight = Integer.parseInt(st.nextToken());
				map[from].add(new Pair(to, weight));
				map[to].add(new Pair(from, weight));
				if(max < weight) {
					max = weight;
				}
			}
			
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken()) - 1;
			
			int start = 1;
			int end = max;
			int ans = 1;
			
			while(start <= end) {
				int mid = (start + end) / 2;
				if(go(mid)) {
					start = mid + 1;
					ans = mid;
				}
				else {
					end = mid - 1;
				}
			}
			
			System.out.println(ans);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static boolean go(int w) {
		boolean[] check = new boolean[N];
		Queue<Integer> queue = new LinkedList<>();
		
		int cur = a;
		queue.add(a);
		check[a] = true;
		
		while(!queue.isEmpty()) {
			cur = queue.remove();
			if(cur == b) {
				return true;
			}
			for(Pair p : map[cur]) {
				if(check[p.n])
					continue;
				if(p.w < w)
					continue;
				queue.add(p.n);
				check[p.n] = true;
			}
		}
		return false;
	}

}

class Pair {
	int n;
	int w;
	Pair(int n, int w){
		this.n = n;
		this.w = w;
	}
}
