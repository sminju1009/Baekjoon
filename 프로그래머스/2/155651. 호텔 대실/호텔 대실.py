from heapq import heappop, heappush

def solution(book_time):
    answer = 1
    # 시간을 분으로 변환하기
    book_time_ref = [(int(s[:2]) * 60 + int(s[3:]), int(e[:2]) * 60 + int(e[3:])) for s, e in book_time]
    # 예약 시간 정렬
    book_time_ref.sort()
    
    # heap 자료구조 이용
    heap = []
    for s, e in book_time_ref:
        if not heap:
            heappush(heap, e+10)
            continue
        if heap[0] <= s:
            heappop(heap)
        else:
             answer += 1
        heappush(heap, e+10)
        
    return answer