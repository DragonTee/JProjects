#include<iostream>
#include<cmath>
#include<cstdlib>

using namespace std;

int signum(int a){
	if (a > 0)
		return 1;
	else
	if (a < 0)
		return -1;
	else
	return 0;
}

int random(int a, int b){
	return a + rand() % (b - 1);
}

int main(){
	char A[100][100];
	int n = 20, m = 10, x = 0, y = 0, s = 5, turn = 0, rtime = 2;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++) {
			A[i][j] = '.';
		}
	for (int i = 0; i < m; i++)
		A[random(0, n)][random(0, n)] = 'o';
	A[0][0] = 'I';
	A[n - 1][n - 1] = '.';
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			cout << A[j][i];
		cout << endl;
	}
	while (true) {
		while (true) {
			char move;
			cin >> move;
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
			cout << "You won" << endl;
			break;
		}
		bool lose = false;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (A[i][j] == 'R') {
					if (abs(x - i) > abs(y - j)) {
						int mv = signum(x - i);
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
						int mv = signum(y - j);
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
			cout << "You lose" << endl;
			break;
		}
		int ro = random(0, 4);
		if (turn % rtime == 0) {
			while (true) {
				int rpos = random(0, n);
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
				cout << A[j][i];
			cout << endl;
		}
		turn++;
	}
}
