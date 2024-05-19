def solution(k, tangerine):
    answer = 0
    box = dict()
    for i in tangerine:
        if i in box:
            box[i] += 1
        else:
            box[i] = 1
    
    # 내림차순 정렬하기
    box_sort = dict(sorted(box.items(), key= lambda item:item[1], reverse=True))
    
    for i in box_sort:
        
        k -= box_sort[i]
        answer += 1
        if k<=0:
            break
    return answer