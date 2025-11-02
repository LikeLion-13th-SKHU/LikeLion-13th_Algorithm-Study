import sys
input = sys.stdin.readline

N, M, K = map(int, input().split())

total_count = 0

for _ in range(N):
    row_str = input().strip() 
    
    con_zeros = 0 
    
    for seat in row_str:
        if seat == '0':
            con_zeros += 1
        else: 
            if con_zeros >= K:
                total_count += (con_zeros - K + 1)
            con_zeros = 0 
            

    if con_zeros >= K:
        total_count += (con_zeros - K + 1)

print(total_count)