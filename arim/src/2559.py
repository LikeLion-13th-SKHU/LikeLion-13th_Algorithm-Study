import sys

input = sys.stdin.readline

n, k = map(int, input().split())

temps = list(map(int, input().split()))

current_sum = sum(temps[0:k])
max_sum = current_sum

for i in range(1, n - k + 1):
    current_sum = current_sum - temps[i - 1] + temps[i + k - 1]
    
    if current_sum > max_sum:
        max_sum = current_sum

print(max_sum)