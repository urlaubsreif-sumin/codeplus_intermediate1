package bs7;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	final static double EPSILON = 1E-6;
	static Point A, B, C;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = new Point(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			B = new Point(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			C = new Point(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			
			double start = 0;
			double end = Math.min(A.calc_dist(C), B.calc_dist(C));
			double ab = A.calc_dist(B);
			double ans = 0.0;
			
			while(Math.abs(start - end) > EPSILON) {
				double mid = (start + end) / 2;
				double res = go(mid);
				if(res > ab) {
					start = mid + EPSILON;
				}
				else {
					end = mid - EPSILON;
				}
				ans = mid;
			}
			
			System.out.println((double)Math.round(ans * 10000000) / 10000000);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static double go(double d) {
		double a1 = Math.sqrt(Math.pow(A.calc_dist(C), 2) - d * d);
		double a2 = Math.sqrt(Math.pow(B.calc_dist(C), 2) - d * d);
		return a1 + a2;
	}

}

class Point {
	int x, y, z;
	Point(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double calc_dist(Point p) {
		double temp = Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2) + Math.pow(z - p.z, 2));
		return temp;
	}
}