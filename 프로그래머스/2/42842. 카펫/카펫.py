def solution(brown, yellow):
    answer = []
    
    # 1. 튜플 형태로 가능한 x, y조합 등록하기
    x_y = []
    for i in range(1, int(yellow**0.5)+1):
        if yellow%i==0:
            x_y.append((yellow//i, i))
    
    # 2. 수식에 맞게 계산하기
    for x, y in x_y:
        if (x+2)*(y+2)==yellow+brown:
            answer.append(x+2)
            answer.append(y+2)
            break
    return answer