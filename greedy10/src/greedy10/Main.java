package greedy10;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		try {
			input = br.readLine();
			int num = 0;
			Queue<Integer> numq = new LinkedList<Integer>();
			Queue<Character> opq = new LinkedList<Character>();
			
			for(int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if(ch <= '9' && ch >= '0') {
					num *= 10;
					num += (ch - '0');
				}
				else if(ch == '-' || ch == '+') {
					numq.add(num);
					num = 0;
					opq.add(ch);
				}
			}
			numq.add(num);

			int size = numq.size();
			int res = numq.remove();
			int p = 0;
			boolean paren = false;
			for(int i = 1; i < size; i++) {
				char op = opq.remove();
				if(op == '+') {
					if(paren) {
						p += numq.remove();
					}
					else {
						res += numq.remove();
					}
				}
				else if(op == '-') {
					res -= p;
					paren = true;
					p = numq.remove();
				}
			}
			
			res -= p;
			
			System.out.println(res);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
