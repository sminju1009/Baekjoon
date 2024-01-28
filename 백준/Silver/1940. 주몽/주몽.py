# test

N = int(input())
M = int(input())
my_list = list(map(int, input().split()))


length = len(my_list)
cnt = 0

for i in range(0, length-1):
    for j in range(i+1, length):
        result = my_list[i] + my_list[j]
        if result != M: continue
        cnt += 1 

print(cnt)