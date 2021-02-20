package sort5;
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
			Student[] list = new Student[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				int k = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				list[i] = new Student(name, k, e, m);
			}
			
			Arrays.sort(list, new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					if(o1.kor < o2.kor) return 1;
					else if(o1.kor > o2.kor) return -1;
					else {
						if(o1.eng > o2.eng) return 1;
						else if(o1.eng < o2.eng) return -1;
						else {
							if(o1.math < o2.math) return 1;
							else if(o1.math > o2.math) return -1;
							else {
								for(int i = 0; i < o1.name.length(); i++) {
									if(o1.name.charAt(i) < o2.name.charAt(i)) return -1;
									else if(o1.name.charAt(i) > o2.name.charAt(i)) return 1;
								}
								return 1;
							}
						}
					}
				}
				
			});
			
			for(Student s : list) {
				sb.append(s.name).append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class Student {
	String name;
	int kor;
	int eng;
	int math;
	Student(String name, int kor, int eng, int math){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
}