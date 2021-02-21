package dc13;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static Point[] list;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			int N = Integer.parseInt(br.readLine());
			list = new Point[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list[i] = new Point(x, y);
			}
			
			Arrays.sort(list);
			
			int ans = go(0, N - 1);
			
			System.out.println(ans);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int go(int s, int e) {
		if(e - s <= 2) {
			int min = 800000000;
			for(int i = s; i < e; i++) {
				Point p1 = list[i];
				int d = p1.get_dist(list[i + 1]);
				if(d < min) {
					min = d;
				}
			}
			return min;
		}
		
		int m = (s + e) / 2;
		int d1 = go(s, m - 1);
		int d2 = go(m + 1, e);
		int min = Math.min(d1, d2);
		
		Point mid = list[m];
		ArrayList<Point> list2 = new ArrayList<>();
		for(int i = s; i <= e; i++) {
			if(Math.pow(mid.x - list[i].x, 2) <= min) {
				list2.add(list[i]);
			}
		}
		
		list2.sort(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.y > o2.y) return 1;
				else if(o1.y < o2.y) return -1;
				else {
					if(o1.x > o2.x) return 1;
					else if(o1.x < o2.x) return -1;
				}
				return 0;
			}
			
		});
		
		for(int i = 0; i < list2.size(); i++) {
			for(int j = i + 1; j < list2.size(); j++) {
				int d = list2.get(i).y - list2.get(j).y;
				if(d * d < min) {
					int t = list2.get(i).get_dist(list2.get(j));
					if(t < min) {
						min = t;
					}
				}
				else {
					break;
				}
			}
		}
		return min;
	}

}

class Point implements Comparable<Point> {
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int get_dist(Point p) {
		int res = (int)Math.pow(this.x - p.x, 2);
		res += (int)Math.pow(this.y - p.y, 2);
		return res;
	}

	@Override
	public int compareTo(Point that) {
		if(this.x < that.x) return -1;
		else if(this.x > that.x) return 1;
		else {
			if(this.y < that.y) return -1;
			else if(this.y > that.y) return 1;
		}
		return 0;
	}
}