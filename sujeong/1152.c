#include <stdio.h>
#include <string.h>

int main(void) {

	char str[1000000];

	scanf_s("%[^\n]s", str, sizeof(str));	// 공백 포함한 문자열을 받기 위해 서식 지정자 "%[^\n]s" 사용

	// 공백 개수 세기
	char* ptr = strchr(str, ' ');	// strchr() : 문자열 내에 일치하는 문자가 있는지 검사하는 함수. 일치하는 문자를 찾지 못하면 NULL 반환
	int count = 0;	// 공백 개수
	while (ptr != NULL) {
		count++;
		ptr = strchr(ptr + 2, ' ');	// 공백이 연속되어 나오는 경우가 없으니 ptr + 2
	}

	// 공백으로 시작하고 공백으로 끝나는 경우
	if (str[0] == ' ' && str[strlen(str) - 1] == ' ') {
		// 공백 수 - 1 = 단어 수
		printf("%d", count - 1);

		return 0;
	}

	// 문자로 시작하고 문자로 끝나는 경우
	if (str[0] != ' ' && str[strlen(str) - 1] != ' ') {
		// 공백 수 + 1 = 단어 수
		printf("%d", count + 1);

		return 0;
	}

	// 그 외 공백 수 = 단어 수
	printf("%d", count);

	return 0;

}