
def solution(sizes):

# w, h 리스트 만들기
    w_list = []
    h_list = []

# for문을 돌면서 w, h 중 큰 값은 w리스트 작은 값은 h리스트에 담는다.
    for i in range(len(sizes)):
        if sizes[i][0]>=sizes[i][1]:
            w_list.append(sizes[i][0])
            h_list.append(sizes[i][1])
        elif sizes[i][0]<sizes[i][1]:
            w_list.append(sizes[i][1])
            h_list.append(sizes[i][0])

# 두 개의 리스트에서 가장 큰 값이 곱한 값이 답이다.
    answer = max(w_list)*max(h_list)
    return answer