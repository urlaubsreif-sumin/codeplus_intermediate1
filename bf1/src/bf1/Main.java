package bf1;
import java.io.*;

public class Main {
	static int[] alpha = new int[26];
	static int[] num;
	static String[] inputs;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			inputs = new String[N];
			for(int i = 0; i < N; i++) {
				inputs[i] = br.readLine();
				for(int j = 0; j < inputs[i].length(); j++) {
					if(alpha[inputs[i].charAt(j) - 'A'] == 0) {
						cnt++;
						alpha[inputs[i].charAt(j) - 'A'] = cnt;
					}
				}
			}
			
			num = new int[cnt];
			for(int i = 0; i < cnt; i++) {
				num[i] = 9 - i;
			}
			
			int max = calc();
			while(prev()) {
				int tmp = calc();
				if(tmp > max) {
					max = tmp;
				}
			}
			
			System.out.println(max);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static boolean prev() {
		//1.인덱스 찾기
		int idx = num.length - 1;
		if(idx == 0) {
			return false;
		}
		while(num[idx] > num[idx - 1]) {
			idx--;
			if(idx == 0) {
				return false;
			}
		}
		//2.num[idx - 1]보다 작은 수 중 가장 큰 수
		int max = -1;
		for(int i = num.length - 1; i >= idx; i--) {
			if(num[i] < num[idx - 1]) {
				max = i;
				break;
			}
		}
		//3.찾은 수와 num[idx - 1] swap
		int temp = num[idx - 1];
		num[idx - 1] = num[max];
		num[max] = temp;
		
		//4. idx-1 오른쪽 수 뒤집기
		int start = idx;
		int end = num.length - 1;
		for(int i = idx; i < (end + start + 1) / 2; i++) {
			temp = num[i];
			num[i] = num[end + start - i];
			num[end + start - i] = temp;
		}
		return true;
	}
	
	public static int calc() {
		int sum = 0;
		for(int i = 0; i < inputs.length; i++) {
			int temp = 0;
			for(int j = 0; j < inputs[i].length(); j++) {
				int ch = inputs[i].charAt(j) - 'A';
				temp *= 10;
				temp += num[alpha[ch] - 1];
			}
			sum += temp;
		}
		
		return sum;
	}
}