package bf10;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] word;
	static int max = 0;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			word = new int[N];
			
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < input.length(); j++) {
					word[i] |= (1 << input.charAt(j) - 'a');
				}
			}
			
			go(0, 0, K);
			
			System.out.println(max);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void go(int idx, int learned, int k) {
		if(k < 0)
			return;
		if(idx == 26) {
			int count = count(learned);
			if(count > max)
				max = count;
			return;
		}
		go(idx + 1, learned | (1 << idx), k - 1);
		if(idx != 'a' - 'a' || idx != 'c' - 'a' || idx != 'i' - 'a' || idx != 'n' - 'a' || idx != 't' - 'a') {
			go(idx + 1, learned, k);
		}
	}
	
	public static int count(int learned) {
		int count = 0;
		for(int i = 0; i < N; i++) {
			if((word[i] & ((1 << 26) - 1 - learned)) == 0) {
				count++;
			}
		}
		return count;
	}
}