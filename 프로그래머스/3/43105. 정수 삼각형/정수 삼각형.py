def solution(triangle):
    
    for i in range(1, len(triangle)):
        for j in range(len(triangle[i])):
            # 가장 왼쪽일 때 혹은 가장 오른쪽일 때
            if j==0:
                triangle[i][j] += triangle[i-1][0]
            elif j==len(triangle[i])-1:
                triangle[i][j] += triangle[i-1][-1]
            # 나머지 경우
            else:
                triangle[i][j] += max(triangle[i-1][j], triangle[i-1][j-1])
    
    return max(triangle[-1])