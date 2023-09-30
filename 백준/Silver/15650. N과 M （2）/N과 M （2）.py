n, m = map(int, input().split())
arr = list(range(1, n + 1))

branch = m
path = [0] * branch

def abc(level, start):
    if level == branch:
        # 출력할 숫자의 조합을 저장하는 리스트
        output = []
        for i in range(branch):
            output.append(arr[path[i]])
        # 출력
        print(' '.join(map(str, output)))
        return
    for i in range(start, n):
        path[level] = i
        abc(level + 1, i + 1)

abc(0, 0)
