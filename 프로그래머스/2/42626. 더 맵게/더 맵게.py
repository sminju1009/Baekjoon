from heapq import heappop, heappush

def solution(scoville, K):
    answer = 0
    count = 0
    heap = []
    for i in range(len(scoville)):
        heappush(heap, scoville[i])
        
    while heap[0]<K:
        if len(heap)<2:
            return -1
        num1 = heappop(heap)
        num2 = heappop(heap)
        answer = num1+2*num2
        count += 1
        heappush(heap, answer)
    
    return count