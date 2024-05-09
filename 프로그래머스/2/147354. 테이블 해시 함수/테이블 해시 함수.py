def solution(data, col, row_begin, row_end):
    # 1. 데이터 정렬
    data.sort(key=lambda x:(x[col-1], -x[0]))
    
    answer = []
    # 2. 나머지 구하는 연산 진행
    for i in range(row_begin-1, row_end):
        ans = 0
        for j in range(len(data[i])):
            ans += (data[i][j]%(i+1))
            if j==len(data[i])-1:
                answer.append(ans)
            
    # 3. xor 연산 진행하기
    res = answer[0]
    for i in range(1, len(answer)):
        res = res ^ answer[i]
        
    return res