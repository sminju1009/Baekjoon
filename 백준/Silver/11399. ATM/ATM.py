n = int(input())
arr = list(map(int, input().split()))

# 오름차순으로 숫자 배열 진행하기
arr.sort()

# 필요한 시간의 최솟값의 합 구하기
res = []
for i in range(n):
    sum_arr = sum(arr[0:i+1])
    res.append(sum_arr)

# 최종 값 출력
print(sum(res))