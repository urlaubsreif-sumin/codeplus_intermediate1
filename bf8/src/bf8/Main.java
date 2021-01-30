package bf8;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] sudoku;
	static boolean[][] domino;
	static boolean[][] check_row; //i번째 row에 j가 존재하는지
	static boolean[][] check_col; //i번쨰 column에 j가 존재하는지
	static boolean[][] check_sq; //i번째 square에 j가 존재하는지
	static StringBuilder sb = new StringBuilder();
	static boolean state; //정답을 찾았는지
	
	public static void main(String[] args) {
		int test = 1; //testcase번호
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			int N = Integer.parseInt(br.readLine());
			while(N != 0) {
				sb.append("Puzzle ").append(test).append('\n');
				test++;
				
				check_row = new boolean[9][9];
				check_col = new boolean[9][9];
				check_sq = new boolean[9][9];
				sudoku = new int[9][9];
				domino = new boolean[9][9];
				
				for(int i = 0; i < 9; i++) {
					for(int j = 0; j < 9; j++) {
						sudoku[i][j] = -1;
					}
					domino[i][i] = true; //같은 숫자로 이루어진 도미노는 존재하지 않으므로 이미 사용했다고 선언
				}
				//원래 들어가있던 도미노들
				for(int i = 0; i < N; i++) {
					st = new StringTokenizer(br.readLine());
					int num1 = Integer.parseInt(st.nextToken()) - 1;
					String loc1 = st.nextToken();
					int r1 = loc1.charAt(0) - 'A';
					int c1 = loc1.charAt(1) - '1';
					sudoku[r1][c1] = num1;
					check_row[r1][num1] = true;
					check_col[c1][num1] = true;
					check_sq[r1 / 3 * 3 + c1 / 3][num1] = true;
					
					int num2 = Integer.parseInt(st.nextToken()) - 1;
					String loc2 = st.nextToken();
					int r2 = loc2.charAt(0) - 'A';
					int c2 = loc2.charAt(1) - '1';
					sudoku[r2][c2] = num2;
					check_row[r2][num2] = true;
					check_col[c2][num2] = true;
					check_sq[r2 / 3 * 3 + c2 / 3][num2] = true;
					
					domino[num2][num1] = true;
					domino[num1][num2] = true;
				}
				//원래 입력되어 있던 한자리 숫자들
				st = new StringTokenizer(br.readLine());
				for(int i = 0; i < 9; i++) {
					String loc = st.nextToken();
					int r = loc.charAt(0) - 'A';
					int c = loc.charAt(1) - '1';
					sudoku[loc.charAt(0) - 'A'][loc.charAt(1) - '1'] = i;
					check_row[r][i] = true;
					check_col[c][i] = true;
					check_sq[r / 3 * 3 + (c / 3)][i] = true;
				}
				
				go(0, 0);
				//'정답을 찾았는지'에 대한 변수는 다시 false로 초기화
				state = false;
				
				N = Integer.parseInt(br.readLine());
			}
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void go(int r, int c) {
		if(state) { //정답을 찾았으면 더이상 출력하지 않아도 되므로 바로 리턴
			return;
		}
		if(r == 9) { //처음 정답을 찾은 경우
			print();
			state = true;
			return;
		}
		if(sudoku[r][c] != -1) { //이미 숫자가 들어가있는 칸인 경우
			c++; //옆칸으로 이동한다.
			go(r + c / 9, c % 9); //c가 8이 넘어가면 다음 줄로 이동하도록
			return;
		}
		
		for(int k = 0; k < 9; k++) { //빈칸인 경우 0~8까지 넣어본다.
			if(!check(r, c, k)) { //해당 row/col/square에 숫자가 있는 경우->넘어간다
				continue;
			}
			for(int l = 0; l < 9; l++) { //도미노의 다른 칸에도 0~8까지 넣어본다.
				if(domino[k][l]) //이미 사용한 도미노의 경우->넘어간다.
					continue;
				//도미노를 가로로 놓는 경우
				if(c + 1 < 9) {
					if(sudoku[r][c + 1] == -1 && check(r, c + 1, l)) {
						sudoku[r][c] = k;
						sudoku[r][c + 1] = l;
						domino[k][l] = true;
						domino[l][k] = true;
						check_row[r][k] = true;
						check_col[c][k] = true;
						check_sq[r / 3 * 3 + c / 3][k] = true;
						check_row[r][l] = true;
						check_col[c + 1][l] = true;
						check_sq[r / 3 * 3 + (c + 1) / 3][l] = true;
						c++;
						go(r + c / 9, c % 9);
						c--;
						sudoku[r][c] = -1;
						sudoku[r][c + 1] = -1;
						domino[k][l] = false;
						domino[l][k] = false;
						check_row[r][k] = false;
						check_col[c][k] = false;
						check_sq[r / 3 * 3 + c / 3][k] = false;
						check_row[r][l] = false;
						check_col[c + 1][l] = false;
						check_sq[r / 3 * 3 + (c + 1) / 3][l] = false;
					}
				}
				//도미노를 세로로 놓는 경우
				if(r + 1 < 9) {
					if(sudoku[r + 1][c] == -1 && check(r + 1, c, l)) {
						sudoku[r][c] = k;
						sudoku[r + 1][c] = l;
						check_row[r][k] = true;
						check_col[c][k] = true;
						check_sq[r / 3 * 3 + c / 3][k] = true;
						check_row[r + 1][l] = true;
						check_col[c][l] = true;
						check_sq[(r + 1) / 3 * 3 + c / 3][l] = true;
						c++;
						go(r + c / 9, c % 9);
						c--;
						sudoku[r][c] = -1;
						sudoku[r + 1][c] = -1;
						check_row[r][k] = false;
						check_col[c][k] = false;
						check_sq[r / 3 * 3 + c / 3][k] = false;
						check_row[r + 1][l] = false;
						check_col[c][l] = false;
						check_sq[(r + 1) / 3 * 3 + c / 3][l] = false;
					}
				}
				
			}
		}
	}
	//해당 row/col/square에 k라는 숫자가 이미 존재하는지 판단
	public static boolean check(int r, int c, int k) {
		if(check_row[r][k] || check_col[c][k] || check_sq[r / 3 * 3 + c / 3][k]) {
			return false;
		}
		return true;
	}
	
	public static void print() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sb.append(sudoku[i][j] + 1);
			}
			sb.append('\n');
		}
	}
}
