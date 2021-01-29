package bf2;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			int N = Integer.parseInt(br.readLine());
			int[] number = new int[N];
			st = new StringTokenizer(br.readLine());
			int total = 0;
			for(int i = 0; i < N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
				total += number[i];
			}
			
			boolean[] res = new boolean[total];
			
			for(int i = 1; i < (1 << N); i++) {
				int sum = 0;
				for(int j = 0; j < N; j++) {
					if((i & (1 << j)) == 0) {
						sum += number[j];
					}
				}
				res[sum] = true;
			}
			
			int answer = total + 1;
			for(int i = 0; i < total; i++) {
				if(!res[i]) {
					answer = i;
					break;
				}
			}
			System.out.println(answer);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
