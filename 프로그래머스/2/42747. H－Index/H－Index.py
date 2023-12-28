'''
h번 이상 인용된 논문이 h편 이상 / 나머지 논문이 h번 이하 인용
'''

def solution(citations):
    n = len(citations)
    citations.sort(reverse=True)
    
    for i in range(n):
        if citations[i]<i+1:
            return i
    return n