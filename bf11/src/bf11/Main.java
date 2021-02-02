package bf11;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static Marble red, blue;
	static int bi, bj; //구슬 위치 초기값
	static int ri, rj;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] board = new char[N][M];
			
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < M; j++) {
					board[i][j] = input.charAt(j);
					if(board[i][j] == 'B') {
						blue = new Marble(i, j);
						bi = i;
						bj = j;
					}
					else if(board[i][j] == 'R') {
						red = new Marble(i, j);
						ri = i;
						rj = j;
					}
				}
			}
			//빨간 구슬과 파란 구슬 객체가 갖는 보드를 동기화시켜주기 위해 static변수로 지정
			Marble.board = new char[N][M];
			//배열 deepcopy 함수를 이용하여 보드 복사
			red.set_board(board);
			
			//비트마스크로 받은 방향 순서를 배열로 변환
			int[] dir = new int[10]; 
			int num = -1;
			for(int i = 0; i < (1 << 20); i++) {
				dir = set_dir(i);
				int ans = go(dir, 0, 0);
				if(num == -1 || (ans != -1 && ans < num)) {
					num = ans;
				}
				//다시 초기화
				blue = new Marble(bi, bj);
				red = new Marble(ri, rj);
				red.set_board(board);
			}
			
			System.out.println(num);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//비트마스크로 받은 방향 순서를 배열로 변환
	public static int[] set_dir(int num) {
		int[] dir = new int[10];
		for(int i = 0; i < 10; i++) {
			dir[i] = (num & 3);
			num >>= 2;
		}
		return dir;
	}
	
	//입력받은 방향 배열로 구슬을 움직여서 count값을 반환한다.
	public static int go(int[] dir, int idx, int count) {
		if(blue.isHole)
			return -1;
		if(red.isHole)
			return count;
		if(idx >= 10)
			return -1;
		//up-0, down-3, right-1, left-2
		if(idx != 0 && dir[idx] == dir[idx - 1]) //이전에 움직였던 방향과 같은 경우
			return -1;
		if(idx != 0 && dir[idx] == ~dir[idx - 1]) //이전에 움직였던 방향과 반대의 경우
			return -1;
		
		boolean rmove = true, bmove = true;
		
		while(true) {
			rmove = red.move(dir[idx]);
			bmove = blue.move(dir[idx]);
			if(!rmove && !bmove) {
				break;
			}
		}
		
		int res = go(dir, idx + 1, count + 1);
		return res;
	}
	
	
}

class Marble {
	int r, c;
	boolean isHole = false;
	static char[][] board;
			
	Marble(int r, int c){
		this.r = r;
		this.c = c;
	}
	
	public void set_board(char[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				Marble.board[i][j] = board[i][j];
			}
		}
	}
	
	public boolean move(int dir) {
		int ni = r, nj = c;
		
		if(isHole) {
			return false;
		}
		switch(dir) {
		case 0: //up
			ni = r - 1;
			break;
		case 1: //right
			nj = c + 1;
			break;
		case 2: //left
			nj = c - 1;
			break;
		case 3: //down
			ni = r + 1;
			break;
		}
		if(board[ni][nj] == '.') { //다음 움직일 곳이 빈칸인 경우,
			swap(r, c, ni, nj); //보드에서 구슬의 위치를 옮긴다.
			r = ni;
			c = nj;
			return true;
		}
		else if(board[ni][nj] == 'O') { //다음 움직일 곳이 구멍인 경우,
			board[r][c] = '.'; //원래 구슬 위치를 빈칸으로 만들고
			r = ni;
			c = nj;
			isHole = true; //해당 구슬의 isHole 변수를 true로 바꿔준다.
			return true;
		}
		return false;
	}
	
	public void swap(int i, int j, int ni, int nj) {
		char temp = board[i][j];
		board[i][j] = board[ni][nj];
		board[ni][nj] = temp;
	}
}