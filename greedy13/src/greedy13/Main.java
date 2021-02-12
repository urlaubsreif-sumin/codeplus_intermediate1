package greedy13;
import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			String input = br.readLine();
			int[] num = new int[input.length()];
			int total = 0;
			boolean zero = false;
			
			for(int i = 0; i < input.length(); i++) {
				int n = input.charAt(i) - '0';
				num[i] = n;
				total += n;
				if(n == 0) zero = true;
			}
			
			Arrays.sort(num);
			
			if(total % 3 != 0 || !zero) {
				System.out.print(-1);
				return;
			}
			else {
				for(int n : num) {
					sb.append(n);
				}
			}
			
			System.out.print(sb.reverse().toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
