package bfs15;
import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			if(s == t)
				System.out.println(0);
			else {
				bfs(s, t);
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void bfs(long s, long t) {
		Queue<Long> queue = new LinkedList<Long>();
		Queue<String> strque = new LinkedList<String>();
		HashSet<Long> set = new HashSet<>();
		
		set.add(s);
		queue.add(s);
		strque.add("");
		
		while(!queue.isEmpty()) {
			long cur = queue.remove();
			String strcur = strque.remove();
			
			if(cur == t) {
				System.out.println(strcur);
				return;
			}
			
			long next = cur * cur;
			if(next <= 1000000000L && !set.contains(next)) {
				queue.add(next);
				set.add(next);
				strque.add(strcur + '*');
			}
			
			next = cur + cur;
			if(next <= 1000000000L && !set.contains(next)) {
				queue.add(next);
				set.add(next);
				strque.add(strcur + '+');
			}
			
			next = cur - cur;
			if(!set.contains(next)) {
				queue.add(next);
				set.add(next);
				strque.add(strcur + '-');
			}
			
			if(cur != 0) {
				next = cur / cur;
				if(!set.contains(next)) {
					queue.add(next);
					set.add(next);
					strque.add(strcur + '/');
				}
			}
		}
		System.out.println(-1);
		
	}

}
