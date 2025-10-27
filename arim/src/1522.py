import sys

s = sys.stdin.readline().strip()
n = len(s)

a_count = s.count('a')

if a_count == 0 or a_count == n:
    print(0)
else:
    doubled_s = s + s
    
    current_b_count = 0
    for i in range(a_count):
        if doubled_s[i] == 'b':
            current_b_count += 1
            
    min_swaps = current_b_count
    
    for i in range(1, n):
        if doubled_s[i - 1] == 'b':
            current_b_count -= 1
            
        if doubled_s[i + a_count - 1] == 'b':
            current_b_count += 1
            
        if current_b_count < min_swaps:
            min_swaps = current_b_count
            
    print(min_swaps)

    