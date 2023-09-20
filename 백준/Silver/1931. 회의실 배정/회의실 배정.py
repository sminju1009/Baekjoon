arr = []
n = int(input())
for _ in range(n):
    arr.append(list(map(int, input().split())))

# 파티가 끝나는 시간 기준으로 sort
arr.sort(key=lambda x:(x[1], x[0]))

endtime = 0
answer = 0
for i in range(len(arr)):
    if endtime<=arr[i][0]:
        endtime = arr[i][1]
        answer += 1

print(answer)