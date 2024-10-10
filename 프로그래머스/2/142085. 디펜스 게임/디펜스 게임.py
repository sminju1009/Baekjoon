from heapq import heappush, heappop

def solution(n, k, enemy):
    stage = len(enemy)
    # 모든 공격에 무적권을 사용할 수 있는 경우
    if k>=stage:
        return stage
    
    q = []
    
    for i in range(stage):
        heappush(q, enemy[i])
        if len(q)>k:
            last = heappop(q)
            if last>n:
                return i
            n -= last
    
    return stage