def dfs(answer, array):
    global n
    if answer==n:
        result.append(array[:])
        return
    if answer>n:
        return
    for i in range(1, 4):
        dfs(answer+i, array+[i])


n, k = map(int, input().split())
result = []
dfs(0, [])
if k>len(result):
    print(-1)
else:
    print("+".join(map(str, result[k-1])))