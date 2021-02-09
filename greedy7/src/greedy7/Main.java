package greedy7;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			ArrayList<Jewel> jewels = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				jewels.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			jewels.sort(new Comparator<Jewel>() {
				@Override
				public int compare(Jewel o1, Jewel o2) {
					if(o1.v > o2.v) return -1;
					else if(o1.v < o2.v) return 1;
					return 0;
				}				
			});
			
			TreeMap<Integer, Integer> bags = new TreeMap<>();
			
			for(int i = 0; i < K; i++) {
				int m = Integer.parseInt(br.readLine());
				bags.put(m, bags.getOrDefault(m, 0) + 1);
			}
			
			long total = 0L;
			
			for(Jewel j : jewels) {
				Map.Entry<Integer, Integer> e = bags.ceilingEntry(j.m);
				if(e == null)
					continue;
				total += j.v;
				if(e.getValue() - 1 > 0) {
					bags.replace(e.getKey(), e.getValue() - 1);
				}
				else {
					bags.remove(e.getKey());
				}
			}
			
			System.out.println(total);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Jewel {
	int m;
	int v;
	Jewel(int m, int v){
		this.m = m;
		this.v = v;
	}
}