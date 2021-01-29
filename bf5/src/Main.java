
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int max = 0;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> marble = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				marble.add(Integer.parseInt(st.nextToken()));
			}
			
			go(marble, 0);
			
			System.out.println(max);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void go(ArrayList<Integer> marble, int e) {
		if(max < e) {
			max = e;
		}
		for(int i = 1; i < marble.size() - 1; i++) {
			int m = marble.remove(i);
			go(marble, e + marble.get(i - 1) * marble.get(i));
			marble.add(i, m);
		}
	}

}
