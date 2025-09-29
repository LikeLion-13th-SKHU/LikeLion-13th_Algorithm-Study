import sys

input = sys.stdin.readline

fruit_counts = {
    "STRAWBERRY": 0,
    "BANANA": 0,
    "LIME": 0,
    "PLUM": 0
}

N = int(input())

for _ in range(N):
    S, X = input().split()
    fruit_counts[S] += int(X)

if 5 in fruit_counts.values():
    print("YES")
else:
    print("NO")