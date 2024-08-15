from collections import defaultdict

def solution(n, results):
    answer = 0
    win = defaultdict(set)
    lose = defaultdict(set)
    
    for i, j in results:
        win[i].add(j)
        lose[j].add(i)
    
    for i in range(1, n+1):
        for winner in win[i]:
            lose[winner].update(lose[i])
        for loser in lose[i]:
            win[loser].update(win[i])
            
    for i in range(1, n+1):
        if len(win[i])+len(lose[i])==n-1:
            answer += 1
            
    return answer