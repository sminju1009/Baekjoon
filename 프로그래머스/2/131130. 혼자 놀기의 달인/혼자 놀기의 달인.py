from collections import deque

def solution(cards):
    visited = [0] * len(cards)
    box_list = []
    
    def bfs(num):
        q = deque([num])
        visited[num] = 1
        level = 0
        
        while q:
            y = q.popleft()
            level += 1
            next_card = cards[y] - 1
            if not visited[next_card]:
                visited[next_card] = 1
                q.append(next_card)
        
        return level
    
    for i in range(len(cards)):
        if not visited[i]:
            box_list.append(bfs(i))
            
    box_list.sort(reverse=True)
    
    if len(box_list) < 2:
        return 0
    else:
        return box_list[0] * box_list[1]
