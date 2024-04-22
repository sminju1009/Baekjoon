def solution(friends, gifts):
    # friends 길이와 gifts 길이 변수 설정
    n = len(friends)
    m = len(gifts)
    
    arr = [[0]*n for _ in range(n)]

    for i in range(m):
        a, b = gifts[i].split()
        for j in range(n):
            for k in range(n):
                if a==friends[j] and b==friends[k]:
                    arr[j][k] += 1
                    
    # 선물을 얼마나 줬는지 넣는 배열
    give = [0] * n
    
    # 선물을 얼마나 받았는지 넣는 배열
    take = [0] * n
    
    # 선물 지수 배열
    result = [0] * n
    
    # 선물 주고받은것 갯수
    present = [0] * n
    
    # 선물 준 횟수, 받은 횟수 넣기
    for i in range(n):
        for j in range(n):
            give[i] += arr[i][j]
            take[i] += arr[j][i]
    
    # 선물 지수 도출하기
    for i in range(n):
        result[i] = give[i] -take[i]
        
    for i in range(n):
        for j in range(n):
            if i!=j:
                # 선물을 주고 받은 기록이 없음
                if arr[i][j]==0 and arr[j][i]==0:
                    if result[i]>result[j]:
                        present[i] += 1

                        
                # 선물을 주고 받은 기록이 있음
                else:
                    # 주고받은 기록이 있는데 주고받은 수가 같음
                    if arr[i][j]==arr[j][i]:
                        # 선물지수가 다른 경우
                        if result[i]>result[j]:
                            present[i] += 1
                                
                    # 주고받은 기록이 있으면서 주고받은 수가 다름
                    else:
                        if arr[i][j]>arr[j][i]:
                            present[i] += 1

    return max(present)
                
        