n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
path = []

def abc(level):
    if level == m:
        print(' '.join(map(str, path)))
        return
    for i in range(n):
        path.append(arr[i])
        abc(level + 1)
        path.pop()

abc(0)