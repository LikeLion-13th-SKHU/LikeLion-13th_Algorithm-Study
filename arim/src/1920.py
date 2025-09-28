import sys

input = sys.stdin.readline

N = int(input())
A = set(map(int, input().split()))

M = int(input())
targets = list(map(int, input().split()))

for target in targets:
    if target in A: 
        print(1)
    else:
        print(0)