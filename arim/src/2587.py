numbers = []

for _ in range(5):
    num = int(input())
    numbers.append(num)

average = sum(numbers) // 5
print(average)

numbers.sort()

median = numbers[2]
print(median)