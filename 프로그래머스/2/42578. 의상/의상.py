def solution(clothes):
    
    closet = {}
    
    for name, kind in clothes:
        if kind in closet.keys():
            closet[kind] += [name]
        else:
            closet[kind] = [name]
            
    # A의 종류가 M개, B의 종류가 n개일 때 가능한 모든 경우의 수(n+1)*(m+1)
    answer = 1
    
    for _, value in closet.items():
        answer *= (len(value)+1)
        
    return answer - 1
    
    