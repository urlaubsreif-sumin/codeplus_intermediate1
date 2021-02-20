package dc12;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static Building[] buildings;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N;
		try {
			N = Integer.parseInt(br.readLine());
			buildings = new Building[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken());
				int h = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				buildings[i] = new Building(l, h, r);
			}
			Arrays.sort(buildings, new Comparator<Building>() {
				@Override
				public int compare(Building o1, Building o2) {
					if(o1.left < o2.left) return -1;
					else if(o1.left > o2.left) return 1;
					else {
						if(o1.height > o2.height) return 1;
						else if(o1.height < o2.height) return -1;
						else {
							if(o1.right < o2.right) return 1;
							else if(o1.right > o2.right) return -1;
						}
					}
					return 0;
				}
			});	
			
			Result res = go(0, N - 1);
			System.out.println(res.toString());
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static Result go(int s, int e) {
		if(s == e) {
			Result left = new Result();
			left.add(new Coord(buildings[s].left, buildings[s].height));
			left.add(new Coord(buildings[s].right, 0));
			return left;
		}
		//divide
		int m = (s + e) / 2;
		Result left = go(s, m);
		Result right = go(m + 1, e);
		//conquer
		return merge(left, right);
	}
	
	public static Result merge(Result left, Result right) {
		int i = 0, j = 0;
		int lh = 0, rh = 0;
		Result res = new Result();
		while(i < left.size() && j < right.size()) {
			Coord l = left.get(i);
			Coord r = right.get(j);
			if(l.x < r.x) {
				lh = l.height;
				res.add(new Coord(l.x, Math.max(lh, rh)));
				i++;
			}
			else if(l.x >= r.x) {
				rh = r.height;
				res.add(new Coord(r.x, Math.max(lh, rh)));
				j++;
			}
		}
		while(i < left.size()) {
			res.add(left.get(i++));
		}
		while(j < right.size()) {
			res.add(right.get(j++));
		}
		return res;
	}

}

class Building {
	int left;
	int height;
	int right;
	Building(int left, int height, int right){
		this.left = left;
		this.height = height;
		this.right = right;
	}
}

class Coord {
	int x;
	int height;
	Coord(int x, int height){
		this.x = x;
		this.height = height;
	}
}

class Result {
	ArrayList<Coord> arr;
	Result(){
		arr = new ArrayList<>();
	}
	public void add(Coord c) {
		if(arr.size() <= 0) {
			arr.add(c);
			return;
		}
		if(arr.get(arr.size() - 1).height == c.height) {
			return;
		}
		if(arr.get(arr.size() - 1).x == c.x) {
			arr.remove(arr.size() - 1);
			arr.add(new Coord(c.x, c.height));
			return;
		}
		arr.add(c);
	}
	public int size() {
		return arr.size();
	}
	public Coord get(int i) {
		return arr.get(i);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i < arr.size()) {
			sb.append(arr.get(i).x).append(' ').append(arr.get(i).height).append(' ');
			i++;
		}
		return sb.toString();
	}
}