n = int(input())

def digit(data):
    res = 0
    for i in data:
        if i.isdigit():
            res += int(i)
    return res


lst = list(input() for _ in range(n))

ans = sorted(lst, key=lambda x:(len(x), digit(x), x))
print(*ans, sep="\n")