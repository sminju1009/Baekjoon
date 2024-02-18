def solution(participant, completion):
    start = {}
    for i in participant:
        if i in start:
            start[i] += 1
        else:
            start[i] = 1
    
    finish = {}
    for i in completion:
        if i in finish:
            finish[i] += 1
        else:
            finish[i] = 1
            
    ans = ''
    for j in participant:
        result = finish.get(j)
        answer = start.get(j)
        if result==answer:
            continue
        else:
            ans = j
    return ans