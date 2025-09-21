#include <stdio.h>

int main(void) {

	int num, count = 0;
	int x, y;

	// 가로, 세로 크기 100인 2차원 배열 선언
	int square[100][100] = { 0 };

	scanf_s("%d", &num); // 색종이 개수 입력

	for (int i = 0; i < num; i++) {
		scanf_s("%d %d", &x, &y);

		// 색종이의 크기에 해당하는 square 배열에 +1
		for (int i = x; i < x + 10; i++) {
			for (int j = y; j < y + 10; j++) {
				square[i][j]++;
			}
		}
	}

	// 1 이상인 배열을 카운트 후 출력
	for (int i = 0; i < 100; i++) {
		for (int j = 0; j < 100; j++) {
			if (square[i][j] >= 1) count++;
		}
	}
	printf("%d", count);
}