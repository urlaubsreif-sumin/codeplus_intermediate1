package greedy2;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Conference> list;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				list.add(new Conference(s, e));
			}
			
			Collections.sort(list, new Comparator<Conference>() {
				@Override
				public int compare(Conference c1, Conference c2) {
					if(c1.end > c2.end) {
						return 1;
					}
					else if(c1.end == c2.end) {
						if(c1.start > c2.start) {
							return 1;
						}
						else if(c1.start == c2.start) {
							return 0;
						}
						else {
							return -1;
						}
					}
					return -1;
				}
			});
			
			
			int ans = 0;
			int cur = 0;
			
			for(int i = 0; i < N; i++) {
				if(cur <= list.get(i).start) {
					cur = list.get(i).end;
					ans++;
				}
			}
			
			System.out.println(ans);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}

class Conference {
	int start;
	int end;
	
	Conference(int s, int e){
		this.start = s;
		this.end = e;
	}
}