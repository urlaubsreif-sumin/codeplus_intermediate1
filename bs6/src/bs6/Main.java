package bs6;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	final static double EPSILON = 1E-6;
	static double x, y, c;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			x = Double.parseDouble(st.nextToken());
			y = Double.parseDouble(st.nextToken());
			c = Double.parseDouble(st.nextToken());
			
			double start = 0;
			double end = Math.min(x, y);
			double ans = 0;
			
			while(Math.abs(start - end) > EPSILON) {
				double mid = (start + end) / 2.0;
				double res = go(mid);
				//System.out.println(res);
				if(res < c) {
					end = mid - EPSILON;
				}
				else if(res >= c) {
					start = mid + EPSILON;
					ans = mid;
				}
			}
			
			System.out.println((double)Math.round(ans*1000)/1000);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static double go(double s) {
		double h1 = Math.sqrt(x * x - s * s);
		double h2 = Math.sqrt(y * y - s * s);
		double c = (h1 * h2) / (h1 + h2);
		return c;
	}
}
