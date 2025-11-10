import sys

input = sys.stdin.readline

N = int(input())

words = set()
for _ in range(N):
    words.add(input().strip())

word_list = list(words)

word_list.sort(key=lambda x: (len(x), x))

for word in word_list:
    print(word)