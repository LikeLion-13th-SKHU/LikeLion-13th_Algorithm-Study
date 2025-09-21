#include <stdio.h>

int main(void) {

	char str[100];

	scanf_s("%s", str, sizeof(str));

	for (int i = 0; i < 100; i++) {
		if (str[i] >= 'a' && str[i] <= 'z') {	// 소문자를 입력했을 때 아스키코드 값에서 32를 빼 대문자로 변환
			str[i] -= 32;
		}
		else if (str[i] >= 'A' && str[i] <= 'Z') {	// 대문자를 입력했을 때 아스키코드 값에서 32를 더해 소문자로 변환
			str[i] += 32;
		}
	}

	printf("%s", str);

	return 0;
}