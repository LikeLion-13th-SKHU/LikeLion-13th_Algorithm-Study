#include <stdio.h>
#include <string.h>

int main(void) {
	char str[100];
	int count = 0;
	int i = 0;

	scanf_s("%s", str, sizeof(str));

	for (i = 0; i < strlen(str); i++) {		// 문자열의 길이 수 만큼 반복
		printf("%c", str[i]);	// 문자열 출력
		count++;

		if (count == 10) {	// 10글자 마다 \n 출력
			printf("\n");
			count = 0;
		}
	}

	return 0;
}

