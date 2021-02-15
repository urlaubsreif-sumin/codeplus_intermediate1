package greedy18;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();
	static int R, C;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			int min = 1000;
			int total = 0;
			int skip_i = 0, skip_j = 0;
			for(int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < C; j++) {
					int n = Integer.parseInt(st.nextToken());
					total += n;
					if((i + j) % 2 != 0) {
						if(min > n) {
							min = n;
							skip_i = i;
							skip_j = j;
						}
					}
				}
			}
			
			if(R % 2 == 0 && C % 2 == 0) {
				total -= min;
				special_case(skip_i, skip_j);
			}
			else if(R % 2 == 0 && C % 2 != 0) {
				for(int j = 0; j < C; j++) {
					for(int i = 0; i < R - 1; i++) {
						if(j % 2 == 0) {
							sb.append("D");
						}
						else {
							sb.append("U");
						}
					}
					if(j != C - 1) {
						sb.append("R");
					}
				}
			}
			else {
				for(int i = 0; i < R; i++) {
					for(int j = 0; j < C - 1; j++) {
						if(i % 2 == 0) {
							sb.append("R");
						}
						else {
							sb.append("L");
						}
					}
					if(i != R - 1) {
						sb.append("D");
					}
				}
			}
			
			System.out.println(sb.toString());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void special_case(int skip_i, int skip_j) {
		int i = 0;
		while(i + 1 < skip_i) {
			for(int k = 0; k < C - 1; k++) {
				sb.append("R");
			}
			sb.append("D");
			for(int k = 0; k < C - 1; k++) {
				sb.append("L");
			}
			sb.append("D");
			i += 2;
		}
		
		i = 0;
		while(R - i - 2 > skip_i) {
			for(int k = 0; k < C - 1; k++) {
				sb2.append("R");
			}
			sb2.append("D");
			for(int k = 0; k < C - 1; k++) {
				sb2.append("L");
			}
			sb2.append("D");
			i += 2;
		}
		
		int j = 0;
		while(j + 1 < skip_j) {
			sb.append("DRU");
			j += 2;
			sb.append("R");
		}
		
		j = 0;
		while(C - j - 2 > skip_j) {
			sb2.append("DRU");
			j += 2;
			sb2.append("R");
		}
		
		if(R - i - 1 == skip_i) {
			sb.append("RD");
		}
		else {
			sb.append("DR");
		}
		
		sb2.reverse();
		sb.append(sb2.toString());
	}

}
