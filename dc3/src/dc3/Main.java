package dc3;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		try {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] A = new int[N];
			int[] B = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				B[j] = Integer.parseInt(st.nextToken());
			}
			
			int a = 0, b = 0;
			while(a < N || b < M) {
				if(a == N) {
					while(b < M) {
						sb.append(B[b]).append(' ');
						b++;
					}
					break;
				}
				else if(b == M) {
					while(a < N) {
						sb.append(A[a]).append(' ');
						a++;
					}
					break;
				}
				if(A[a] <= B[b]) {
					sb.append(A[a]).append(' ');
					a++;
				}
				else if(A[a] > B[b]) {
					sb.append(B[b]).append(' ');
					b++;
				}
			}
			
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
