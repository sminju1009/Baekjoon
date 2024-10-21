n = int(input())
arr = []
arr_boj = []
for i in range(n):
    a = input()
    if a.startswith("boj.kr/"):
        arr_boj.append(a)
    else:
        arr.append(a)

arr.sort(key=lambda x:(len(x), x))
arr_boj.sort(key=lambda x:(len(x), x))

res = arr + arr_boj

for i in res:
    print(i, end="\n")