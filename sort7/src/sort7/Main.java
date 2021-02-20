package sort7;
import java.io.*;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Long, Integer> hm = new HashMap<>();
		
		try {
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++) {
				long n = Long.parseLong(br.readLine());
				hm.put(n, hm.getOrDefault(n, 0) + 1);
			}
			
			int max = 0;
			long ans = 0;
			
			for(Entry<Long, Integer> e : hm.entrySet()) {
				if(e.getValue() > max) {
					ans = e.getKey();
					max = e.getValue();
				}
				else if(e.getValue() == max) {
					if(e.getKey() < ans) {
						ans = e.getKey();
						max = e.getValue();
					}
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
