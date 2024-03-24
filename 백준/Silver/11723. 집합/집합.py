import sys
input = sys.stdin.readline

n = int(input())
arr = set()
for _ in range(n):
    lst = list(input().split())
    a = lst[0]
    if a=='add':
        if int(lst[1]) not in arr:
            arr.add(int(lst[1]))
    elif a=='remove':
        if int(lst[1]) in arr:
            arr.remove(int(lst[1]))
    elif a=='check':
        if int(lst[1]) in arr:
            print(1)
        else:
            print(0)
    elif a=='toggle':
        if int(lst[1]) in arr:
            arr.remove(int(lst[1]))
        else:
            arr.add(int(lst[1]))
    elif a=='all':
        arr = set([i for i in range(1, 21)])
    elif a=='empty':
        arr = set()