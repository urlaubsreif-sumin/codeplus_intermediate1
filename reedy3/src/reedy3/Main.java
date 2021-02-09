package reedy3;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> time = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				time.add(Integer.parseInt(st.nextToken()));
			}
			
			int total = 0;
			int ans = 0;
			
			time.sort(null);
			
			for(int i = 0; i < N; i++) {
				total += time.get(i);
				ans += total;
			}
			
			System.out.println(ans);
			
			
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
