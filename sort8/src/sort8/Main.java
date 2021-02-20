package sort8;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine());
			Init[] list = new Init[N];
			
			for(int i = 0; i < N; i++) {
				int n = Integer.parseInt(br.readLine());
				list[i] = new Init(n, i);
			}
			
			Arrays.sort(list, new Comparator<Init>() {

				@Override
				public int compare(Init o1, Init o2) {
					if(o1.num < o2.num) return -1;
					else if(o1.num > o2.num) return 1;
					return 0;
				}
				
			});
			
			int max = 0;
			for(int i = 0; i < N; i++) {
				int k = list[i].pos - i;
				if(k > max) {
					max = k;
				}
			}
			
			System.out.println(max + 1);
			
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class Init {
	int num;
	int pos;
	Init(int num, int pos){
		this.num = num;
		this.pos = pos;
	}
}