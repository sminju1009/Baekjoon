def solution(n, lost, reserve):
    answer = 0
    # 미리 가져왔지만 잃어버린 학생은 lost와 reserve에서 제거하기
    for i in range(1, n+1):
        for j in range(1, n+1):
            if i==j:
                if i in lost and i in reserve:
                    lost.remove(i)
                    reserve.remove(i)
                    
    # 체육복 빌려주는 경우 가정
    for i in range(1, n+1):
        # 1번이 아니고 앞 사람이 있을 때
        if i!=1 and i in lost and i-1 in reserve:
            answer += 1
            lost.remove(i)
            reserve.remove(i-1)
        # 뒷 사람이 있을 때
        elif i!=n and i in lost and i+1 in reserve:
            answer += 1
            lost.remove(i)
            reserve.remove(i+1)
    
    answer = n - len(lost)
    return answer
        