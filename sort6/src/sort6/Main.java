package sort6;
import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			int N = Integer.parseInt(br.readLine());
			int[] list = new int[N];
			
			for(int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(list);
			
			for(int i : list) {
				sb.append(i).append('\n');
			}
			
			System.out.println(sb.toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
