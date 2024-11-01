from collections import defaultdict

def solution(k, tangerine):
    answer = 0
    box = defaultdict(int)
    for i in tangerine:
        box[i] += 1
    
    # 내림차순 정렬하기
    box_sort = dict(sorted(box.items(), key= lambda item:item[1], reverse=True))
        
    for i in box_sort:
        
        k -= box_sort[i]
        answer += 1
        if k<=0:
            break
    return answer