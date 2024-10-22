def solution(s):
    answer = []
    t = []
    
    temp = s.split("}")
    for i in temp:
        a = i.split("{")
        for j in a:
            if j!='':
                t.append(j)
    
    h = []
    for i in t:
        if i!=',':
            h.append(i)
    
    h.sort(key=lambda x:x.count(','))
    
    for i in h:
        a = i.split(",")
        for j in a:
            if int(j) not in answer:
                answer.append(int(j))
        
    return answer