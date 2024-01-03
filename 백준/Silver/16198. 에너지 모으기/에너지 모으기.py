def dfs(x):
    global answer
    # 에너지 구슬이 2개가 되면 그 때의 최대 에너지 값으로 초기화한다.
    if len(arr)==2:
        answer = max(x, answer)
        return
    # 반복문을 통해 에너지 구슬을 확인
    for i in range(1, len(arr)-1):
        # 에너지 모으기
        target = arr[i-1] * arr[i+1]

        # 백트래킹
        # 에너지 구슬 제거거
        v = arr.pop(i)
        dfs(x+target)
        # 제거한 에너지 구슬 추가
        arr.insert(i, v)

n = int(input())
arr = list(map(int, input().split()))
answer = 0
dfs(0)
print(answer)