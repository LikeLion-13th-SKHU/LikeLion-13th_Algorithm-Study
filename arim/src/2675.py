T = int(input())
for _ in range(T):
    R_str, S = input().split()
    R = int(R_str)
    
    S_word = list(S)
    P = ""

    for i in S_word:
        P += i * R
        
    print(P)