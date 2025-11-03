import sys

input = sys.stdin.readline

n, x = map(int, input().split())

visitor = list(map(int, input().split()))

current_sum = sum(visitor[0:x])
max_sum = current_sum
count = 1

for i in range(1, n - x + 1):
    
    current_sum = current_sum - visitor[i - 1] + visitor[i + x - 1]
    
    if current_sum > max_sum:
        max_sum = current_sum
        count = 1  
    elif current_sum == max_sum:
        count += 1 

if max_sum == 0:
    print("SAD")
else:
    print(max_sum)
    print(count)
    