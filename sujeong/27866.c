#include <stdio.h>

int main() {

	char str[1000];	// 단어를 저장하기 위한 문자열
	int num1 = 0;

	scanf_s("%s", str, sizeof(str));
	scanf_s("%d", &num1);

	printf("%c", str[num1 - 1]);	// 배열의 시작은 0이니 1 빼주기

	return 0;

}

