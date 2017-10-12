import java.util.Scanner;

public class Robot {

	public Robot() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		char A[][] = new char[100][100];
		int n = 10, m = 10, x = 0, y = 0, s = 5, turn = 0, rtime = 2;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				A[i][j] = '.';
			}
		for (int i = 0; i < m; i++)
			A[(int)(Math.random() * n)][(int)(Math.random() * n)] = 'o';
		A[0][0] = 'I';
		A[n - 1][n - 1] = '.';
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(A[j][i]);
			System.out.println();
		}
		Scanner reader = new Scanner(System.in);
		while (true) {
			while (true) {
				char move = reader.next().charAt(0);
				if (move == 'D' && y + 1 < n && A[x][y + 1] == '.') {
					A[x][y + 1] = 'I';
					A[x][y] = '.';
					y += 1;
					break;
				}
				if (move == 'U' && y - 1 >= 0 && A[x][y - 1] == '.') {
					A[x][y - 1] = 'I';
					A[x][y] = '.';
					y -= 1;
					break;
				}
				if (move == 'R' && x + 1 < n && A[x + 1][y] == '.') {
					A[x + 1][y] = 'I';
					A[x][y] = '.';
					x += 1;
					break;
				}
				if (move == 'L' && x - 1 >= 0 && A[x - 1][y] == '.') {
					A[x - 1][y] = 'I';
					A[x][y] = '.';
					x -= 1;
					break;
				}
				if (move == 'd' && y + 1 < n && A[x][y + 1] == 'R' && s > 0) {
					A[x][y + 1] = '.';
					s--;
					break;
				}
				if (move == 'u' && y - 1 >= 0 && A[x][y - 1] == 'R' && s > 0) {
					A[x][y - 1] = '.';
					s--;
					break;
				}
				if (move == 'r' && x + 1 < n && A[x + 1][y] == 'R' && s > 0) {
					A[x + 1][y] = '.';
					s--;
					break;
				}
				if (move == 'l' && x - 1 >= 0 && A[x - 1][y] == 'R' && s > 0) {
					A[x - 1][y] = '.';
					s--;
					break;
				}
				if (move == 'W') {
					break;
				}
			}
			if (x == n - 1 && y == n - 1) {
				System.out.println("You won");
				break;
			}
			boolean lose = false;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					if (A[i][j] == 'R') {
						if (Math.abs(x - i) > Math.abs(y - j)) {
							int mv = (int) Math.signum(x - i);
							if (i + mv < n && i + mv >= 0) {
								if (A[i + mv][j] == '.') {
									A[i + mv][j] = 'r';
									A[i][j] = '.';
								}
								if (A[i + mv][j] == 'o') {
									A[i][j] = '.';
								}
								if (A[i + mv][j] == 'I') {
									lose = true;
									A[x][y] = '.';
								}
							}
						}
						else {
							int mv = (int) Math.signum(y - j);
							if (j + mv < n && j + mv >= 0) {
								if (A[i][j + mv] == '.') {
									A[i][j + mv] = 'r';
									A[i][j] = '.';
								}
								if (A[i][j + mv] == 'o') {
									A[i][j] = '.';
								}
								if (A[i][j + mv] == 'I') {
									lose = true;
									A[x][y] = ',';
								}
							}
						}
							
					}
				}
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (A[i][j] == 'r')
						A[i][j] = 'R';
			if (lose) {
				System.out.println("You lose");
				break;
			}
			int ro = (int) (Math.random() * 4);
			if (turn % rtime == 0) {
				while (true) {
					int rpos = (int) (Math.random() * n);
					if (ro == 0 && A[rpos][0] == '.')
					{
						A[rpos][0] = 'R';
						break;
					}
					if (ro == 1 && A[0][rpos] == '.')
					{
						A[0][rpos] = 'R';
						break;
					}
					if (ro == 2 && A[rpos][n - 1] == '.')
					{
						A[rpos][n - 1] = 'R';
						break;
					}
					if (ro == 3 && A[n - 1][rpos] == '.')
					{
						A[n - 1][rpos] = 'R';
						break;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					System.out.print(A[j][i]);
				System.out.println();
			}
			turn++;
		}
		reader.close();
	}

}
