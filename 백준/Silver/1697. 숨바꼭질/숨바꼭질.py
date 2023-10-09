# chatgpt

from collections import deque

def bfs(n, k):
    visited = [False] * 100001  # 방문 여부를 저장할 리스트
    q = deque([(n, 0)])  # 시작 위치와 시간을 큐에 넣음

    while q:
        current, time = q.popleft()

        if current == k:  # 목표 위치에 도달했을 때
            return time

        # 다음 이동할 위치들을 계산
        next_positions = [current - 1, current + 1, current * 2]

        for next_pos in next_positions:
            if 0 <= next_pos <= 100000 and not visited[next_pos]:
                visited[next_pos] = True
                q.append((next_pos, time + 1))

n, k = map(int, input().split())
result = bfs(n, k)
print(result)