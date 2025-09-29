import sys
from itertools import permutations

n = int(sys.stdin.readline())
k = int(sys.stdin.readline())
cards = [sys.stdin.readline().strip() for _ in range(n)]

results = set()

for p in permutations(cards, k):
    results.add(''.join(p))

print(len(results))