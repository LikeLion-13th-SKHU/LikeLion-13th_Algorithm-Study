import sys

input = sys.stdin.readline

n = int(input())

company = set()

for _ in range(n):
    name, status = input().split()

    if status == "enter":
        company.add(name)
    else:
        company.remove(name)

result = sorted(list(company), reverse=True)

for name in result:
    print(name)