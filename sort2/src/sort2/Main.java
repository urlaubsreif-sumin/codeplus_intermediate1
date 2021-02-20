package sort2;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		try {
			int N = Integer.parseInt(br.readLine());
			Coord[] pairs = new Coord[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				pairs[i] = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(pairs, new Comparator<Coord>() {

				@Override
				public int compare(Coord o1, Coord o2) {
					if(o1.x > o2.x) {
						return 1;
					}
					else if(o1.x < o2.x) {
						return -1;
					}
					else {
						if(o1.y > o2.y) {
							return 1;
						}
						else if(o1.y < o2.y) {
							return -1;
						}
						else {
							return 0;
						}
					}
				}
				
			});
			
			for(Coord c : pairs) {
				sb.append(c.x).append(' ').append(c.y).append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class Coord {
	int x;
	int y;
	Coord(int x, int y){
		this.x = x;
		this.y = y;
	}
}
