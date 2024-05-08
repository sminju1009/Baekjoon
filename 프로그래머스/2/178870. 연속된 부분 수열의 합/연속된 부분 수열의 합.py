def solution(sequence, k): 
    answer = []
    start, end = 0, -1
    ans = 0
    while True:
        if ans<k:
            end += 1
            if end >= len(sequence):
                break
            ans += sequence[end]
        else:
            ans -= sequence[start]
            if start >= len(sequence):
                break
            start += 1
        if ans==k:
            answer.append([start, end])
    answer.sort(key=lambda x: (x[1]-x[0], x[0]))
    return answer[0]