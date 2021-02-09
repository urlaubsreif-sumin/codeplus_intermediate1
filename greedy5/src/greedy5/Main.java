package greedy5;
import java.io.*;

public class Main {
	static int N;
	static int[] lights2;
	static int[] lights;
	static int[] result;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			lights = new int[N];
			lights2 = new int[N];
			result = new int[N];
			boolean same = true;
			
			String input = br.readLine();
			for(int i = 0; i < N; i++) {
				lights2[i] = input.charAt(i) - '0';
				lights[i] = input.charAt(i) - '0';
			}
			input = br.readLine();
			for(int i = 0; i < N; i++) {
				result[i] = input.charAt(i) - '0';
				if(same && result[i] != lights[i]) {
					same = false;
				}
			}
			
			if(same) {
				System.out.println(0);
				return;
			}
			if(N < 2) {
				System.out.println(-1);
				return;
			}
			
			int ans = 1;
			//첫번째 스위치를 켠 경우
			toggle(0);
			for(int i = 1; i < N; i++) {
				if(lights[i - 1] - result[i - 1] != 0) {
					toggle(i);
					ans++;
				}
			}
			if(lights[N - 1] == result[N - 1]) {
				System.out.println(ans);
				return;
			}
			
			//첫번째 스위치를 켜지 않은 경우
			ans = 0;
			for(int i = 1; i < N; i++) {
				if(lights2[i - 1] - result[i - 1] != 0) {
					toggle2(i);
					ans++;
				}
			}
			if(lights2[N - 1] == result[N - 1]) {
				System.out.println(ans);
				return;
			}
			
			System.out.println(-1);
			return;
				
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void toggle(int i) {
		if(i == 0) {
			lights[i] = (lights[i] + 1) % 2;
			lights[i + 1] = (lights[i + 1] + 1) % 2;
		}
		else if(i == N - 1) {
			lights[i] = (lights[i] + 1) % 2;
			lights[i - 1] = (lights[i - 1] + 1) % 2;
		}
		else {
			lights[i] = (lights[i] + 1) % 2;
			lights[i + 1] = (lights[i + 1] + 1) % 2;
			lights[i - 1] = (lights[i - 1] + 1) % 2;
		}
	}
	
	public static void toggle2(int i) {
		if(i == 0) {
			lights2[i] = (lights2[i] + 1) % 2;
			lights2[i + 1] = (lights2[i + 1] + 1) % 2;
		}
		else if(i == N - 1) {
			lights2[i] = (lights2[i] + 1) % 2;
			lights2[i - 1] = (lights2[i - 1] + 1) % 2;
		}
		else {
			lights2[i] = (lights2[i] + 1) % 2;
			lights2[i + 1] = (lights2[i + 1] + 1) % 2;
			lights2[i - 1] = (lights2[i - 1] + 1) % 2;
		}
	}

}
