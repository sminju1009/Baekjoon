from collections import deque

def solution(cards):
    visited = [0] * len(cards)
    box_list = []
    
    def bfs(num):
        q = deque()
        q.append((num, 1))
        visited[num] = 1
        
        while q:
            y, level = q.popleft()
            if not visited[cards[y]-1]:
                visited[cards[y]-1] = 1
                q.append((cards[y]-1, level+1))
            else:
                return level
    
    for i in range(len(cards)):
        if not visited[i]:
            box_list.append(bfs(i))
            
    box_list.sort(reverse=True)
    
    if len(box_list) < 2:
        return 0
    else:
        return box_list[0] * box_list[1]
