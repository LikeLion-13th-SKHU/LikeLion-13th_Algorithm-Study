import sys

input = sys.stdin.readline

n, m = map(int, input().split())

col_sums = [0] * m

for _ in range(n):
    row = list(map(int, input().split()))
 
    for j in range(m):
        col_sums[j] += row[j]

a = int(input().strip())

current_sum = sum(col_sums[0:a])
max_sum = current_sum
for i in range(1, m - a + 1):
    current_sum = current_sum - col_sums[i - 1] + col_sums[i + a - 1]
    
    if current_sum > max_sum:
        max_sum = current_sum
        
print(max_sum)