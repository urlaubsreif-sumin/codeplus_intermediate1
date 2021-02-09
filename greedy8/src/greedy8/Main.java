package greedy8;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Lecture> list = new ArrayList<>();
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				list.add(new Lecture(d, p));
			}
			
			list.sort(new Comparator<Lecture>() {
				@Override
				public int compare(Lecture o1, Lecture o2) {
					if(o1.d > o2.d) return -1;
					else if(o1.d < o2.d) return 1;
					else {
						if(o1.p > o2.p) return -1;
						else if(o1.p < o2.p) return 1;
						else {
							return 0;
						}
					}
				}
			});
			
			int total = 0;
			int idx = 0;
			PriorityQueue<Integer> queue = new PriorityQueue<>();
			for(int i = 10000; i > 0; i--) {
				while(idx < n && list.get(idx).d == i) {
					queue.add(-list.get(idx).p);
					idx++;
				}
				if(!queue.isEmpty()) {
					total += (-queue.poll());
				}
			}
			
			System.out.println(total);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}

class Lecture {
	int d;
	int p;
	Lecture(int d, int p){
		this.d = d;
		this.p = p;
	}
}
