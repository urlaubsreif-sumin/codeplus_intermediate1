package sort4;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		try {
			int N = Integer.parseInt(br.readLine());
			People[] list = new People[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				list[i] = new People(Integer.parseInt(st.nextToken()), st.nextToken());
			}
			
			Arrays.sort(list, new Comparator<People>() {

				@Override
				public int compare(People o1, People o2) {
					if(o1.age > o2.age) {
						return 1;
					}
					else if(o1.age < o2.age) {
						return -1;
					}
					else {
						return 0;
					}
				}
			});
			
			for(People p : list) {
				sb.append(p.age).append(' ').append(p.name).append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class People {
	int age;
	String name;
	People(int age, String name){
		this.age = age;
		this.name = name;
	}
}
