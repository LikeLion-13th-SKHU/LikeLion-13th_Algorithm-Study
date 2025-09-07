N = int(input())
N_str=input()

total_sum = 0

for N_char in N_str:
    total_sum += int(N_char)
    
print(total_sum)