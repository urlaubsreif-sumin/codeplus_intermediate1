package dc6;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] inorder;
	static int[] postorder;
	static int[] location;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			int N = Integer.parseInt(br.readLine());
			inorder = new int[N];
			postorder = new int[N];
			location = new int[100001];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				inorder[i] = Integer.parseInt(st.nextToken());
				location[inorder[i]] = i;
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				postorder[i] = Integer.parseInt(st.nextToken());
			}
			
			go(0, N - 1, 0, N - 1);
			
			System.out.println(sb.toString());
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void go(int ins, int ine, int ps, int pe) {
		if(ins > ine || ps > pe)
			return;
		int n = postorder[pe];
		sb.append(n).append(' ');
		int idx = location[n];
		
		go(ins, idx - 1, ps, ps + idx - ins - 1);
		go(idx + 1, ine, ps + idx - ins, pe - 1);
	}
}
