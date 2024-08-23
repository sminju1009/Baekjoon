from collections import deque

def solution(begin, target, words):
    if target not in words:
        return 0  # target이 words에 없는 경우 변환할 수 없으므로 0 반환

    answer = 0
    visited = [0] * len(words)
    q = deque()
    q.append((begin, 0))
    
    while q:
        word, cnt = q.popleft()
        if word == target:
            answer = cnt
            break
        for i in range(len(words)):
            if not visited[i]:
                temp_cnt = 0
                for j in range(len(word)):
                    if words[i][j] != word[j]:
                        temp_cnt += 1
                if temp_cnt == 1:  # 한 글자만 다른 경우에만 큐에 추가
                    q.append((words[i], cnt + 1))
                    visited[i] = 1
    
    return answer