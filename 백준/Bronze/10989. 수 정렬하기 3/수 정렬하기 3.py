# 외부 사이트 보고 푼 코드
# 출처 https://velog.io/@yje876/python%EB%B0%B1%EC%A4%80DP-10989-%EC%88%98-%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0-3

import sys

n = int(sys.stdin.readline())
arr = [0]*10001

for _ in range(n):
    num = int(sys.stdin.readline())
    arr[num] += 1
    
for i in range(10001):
    if arr[i]!=0:
        for j in range(arr[i]):
            print(i)