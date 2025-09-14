#include <stdio.h>

int main(void) {

	int num[10];
	int result[42] = { 0 };
	int count = 0;

	// 10개의 정수 입력
	for (int i = 0; i < 10; i++) {
		scanf_s("%d", &num[i]);
	}

	// 나머지에 해당하는 배열에 +1
	for (int i = 0; i < 10; i++) {

		result[num[i] % 42]++;
	}

	// 1 이상인 배열을 카운트 후 출력
	for (int i = 0; i < 42; i++) {
		if (result[i] >= 1) count++;
	} printf("%d", count);
}