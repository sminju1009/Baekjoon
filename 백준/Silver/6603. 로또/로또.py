def dfs(level, start):
    if level == 6:
        print(*path)
        return
    for i in range(start, len(lotto)):
        path[level] = lotto[i]
        dfs(level + 1, i + 1)

while True:
    arr = list(map(int, input().split()))
    count = arr[0]
    lotto = arr[1:]
    lotto.sort()  # 로또 숫자를 정렬
    path = [0] * 6  # path 배열 초기화
    dfs(0, 0)
    if count ==0:
        exit()
    print()