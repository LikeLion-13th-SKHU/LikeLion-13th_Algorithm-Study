#include <stdio.h>
#include <string.h>

int main(void) {
	char str1[1000], str2[1000];

	scanf_s("%s", str1, sizeof(str1));
	scanf_s("%s", str2, sizeof(str2));

	// strlen() 함수로 문자열의 길이를 구한 뒤, 삼항 연산자를 사용해 조건식 작성
	strlen(str1) >= strlen(str2) ? printf("go") : printf("no");		

	return 0;
	 
}