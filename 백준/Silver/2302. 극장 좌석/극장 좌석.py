n = int(input())
m = int(input())

# 칸 수에 따른 자리 바꿀 수 있는 경우의 수 구하기
dp = [0] * (n + 1)
dp[0] = 1
if n > 1:
    dp[1] = 2
for i in range(2, n + 1):
    dp[i] = dp[i - 1] + dp[i - 2]

# 좌석 - 전부 0으로 셋팅
seats = [0] * n
# 고정석인 경우는 -1로 설정하기(옮길 수 없는 경우)
for _ in range(m):
    a = int(input())
    seats[a - 1] = -1

# 경우의 수 구하기
cases = []
cnt = 0
for i in range(n):
    if seats[i] == 0:
        cnt += 1
    else:
        cases.append(cnt)
        cnt = 0
cases.append(cnt)  # 마지막 구간 추가

# 모든 숫자 곱하기
answer = 1
for c in cases:
    if c != 0:
        answer *= dp[c - 1]

print(answer)