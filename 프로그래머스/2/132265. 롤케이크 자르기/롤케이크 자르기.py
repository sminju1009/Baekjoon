from collections import Counter

def solution(topping):
    answer = 0
    dic = Counter(topping)
    compare = set()
    for i in topping:
        compare.add(i)
        dic[i] -= 1
        if dic[i]==0:
            dic.pop(i)
        if len(compare)==len(dic):
            answer+=1
    
    return answer