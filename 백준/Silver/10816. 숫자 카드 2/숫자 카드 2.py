# 10816. 숫자 카드 2

n = int(input())
arr1 = list(map(int, input().split()))

m = int(input())
arr2 = list(map(int, input().split()))

count = {}
for i in arr1:
    if i in count:
        count[i] += 1
    else:
        count[i] = 1

for j in arr2:
    result = count.get(j)
    if result==None:
        print(0, end=" ")
    else:
        print(result, end=" ")