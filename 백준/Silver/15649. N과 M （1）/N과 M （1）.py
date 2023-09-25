# 문어박사님 풀이

def dfs(n, lst):
    # 종료조건(n에 관련된 형태) 처리, 정답 처리
    if n==M:            # m개의 수열을 완성
        ans.append(lst)
        return

    # 하부(단계)함수 호출
    for j in range(1, N+1):
        if v[j]==0:         # 선택하지 않은 숫자인 경우 추가
            v[j] = 1
            dfs(n+1, lst+[j])
            v[j] = 0        # 다녀와서는 0으로 초기화

N, M = map(int, input().split())
ans = []                    # 정답을 저장할 리스트
v = [0] * (N+1)             # 중복을 확인할 visited 배열

dfs(0, [])
for lst in ans:
    print(*lst)