n = int(input())
numbers = list(map(int, input().split()))

min_val = numbers[0]
max_val = numbers[0]

for i in range(1, n):
    if numbers[i] < min_val:
        min_val = numbers[i]
    if numbers[i] > max_val:
        max_val = numbers[i]

print(min_val, max_val)