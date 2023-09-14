# bj 1822 - 내 방식대로 풀이해 보기

na, nb = map(int, input().split())
lst_na = set(map(int, input().split()))
lst_nb = set(map(int, input().split()))

arr = []

for i in lst_na:
    if i not in lst_nb:
        arr.append(i)

arr.sort()

if arr==[]:
    print(0)
else:
    print(len(arr))
    print(*arr)