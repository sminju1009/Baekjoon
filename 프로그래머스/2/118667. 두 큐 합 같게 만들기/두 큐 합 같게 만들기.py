from collections import deque

def function(queue1, queue2):
    cnt = 0 # 작업한 횟수
    sum1, sum2 = sum(queue1), sum(queue2)
    total_operations = 0
    
    # deque로 변환하여 pop(0)의 시간 복잡도를 줄임
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    
    while cnt < 2 * (len(queue1) + len(queue2)):  # 최대 작업 횟수 제한
        if sum1 == sum2:
            return total_operations
        
        if sum1 > sum2:
            if queue1:
                a = queue1.popleft()
                queue2.append(a)
                sum1 -= a
                sum2 += a
        else:
            if queue2:
                a = queue2.popleft()
                queue1.append(a)
                sum2 -= a
                sum1 += a
        
        cnt += 1
        total_operations += 1
    
    return -1

def solution(queue1, queue2):
    result = function(queue1, queue2)      
    return result