#include <stdio.h>

int main(void) {
	int x, y;
	int A[100][100] = { 0 };
	int B[100][100] = { 0 };


	scanf_s("%d %d", &x, &y);

	// 배열 A 입력
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < y; j++) {
			scanf_s("%d", &A[i][j]);
		}
	}

	// 배열 B 입력
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < y; j++) {
			scanf_s("%d", &B[i][j]);
		}
	}

	// 배열 A + B  계산 후 출력
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < y; j++) {
			A[i][j] += B[i][j];
			printf("%d ", A[i][j]);
		}
		printf("\n");
	}
}