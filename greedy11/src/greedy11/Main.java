package greedy11;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> pos = new ArrayList<Integer>();
			ArrayList<Integer> neg = new ArrayList<Integer>();
			int zero = 0;
			int one = 0;
			for(int i = 0; i < N; i++) {
				int num = Integer.parseInt(br.readLine());
				if(num == 0) {
					zero++;
				}
				else if(num == 1) {
					one++;
				}
				else if(num > 1) {
					pos.add(num);
				}
				else if(num < 0) {
					neg.add(num);
				}
			}
			Collections.sort(pos);
			Collections.reverse(pos);
			Collections.sort(neg);
			
			int res = 0;
			
			if(pos.size() % 2 != 0) {
				pos.add(1);
			}
			if(neg.size() % 2 != 0) {
				neg.add(zero == 0 ? 1 : 0);
			}
			
			int idx = 0;
			while(idx < pos.size()) {
				int num1 = pos.get(idx);
				int num2 = pos.get(idx + 1);
				res += (num1 * num2);
				idx += 2;
			}
			
			idx = 0;
			while(idx < neg.size()) {
				int num1 = neg.get(idx);
				int num2 = neg.get(idx + 1);
				res += (num1 * num2);
				idx += 2;
			}
			
			res += one;
			
			System.out.println(res);
			
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
