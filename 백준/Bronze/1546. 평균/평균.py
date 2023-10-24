n = int(input())
arr = list(map(int, input().split()))

# 최댓값 고르기
maxi = max(arr)

# 점수 수정하기
for i in range(n):
    arr[i] = (arr[i]/maxi)*100

print(sum(arr)/n)