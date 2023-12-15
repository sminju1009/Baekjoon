n, m = map(int, input().split())
arr = sorted(list(map(int, input().split())))
result = []

def dfs():
    if len(result)==m:
        print(*result)
        return
    double = 0
    for i in range(n):
        if double != arr[i]:
            result.append(arr[i])
            double = arr[i]
            dfs()
            result.pop()

dfs()