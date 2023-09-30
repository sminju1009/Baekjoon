n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
visited = [0] * n
path = []

def abc(level):
    if level == m:
        print(' '.join(map(str, path)))
        return
    for i in range(n):
        if level==0:
            visited[i] = 1
            path.append(arr[i])
            abc(level + 1)
            visited[i] = 0
            path.pop()
        else:
            if path[level-1]<arr[i]:
                visited[i] = 1
                path.append(arr[i])
                abc(level + 1)
                visited[i] = 0
                path.pop()

abc(0)
