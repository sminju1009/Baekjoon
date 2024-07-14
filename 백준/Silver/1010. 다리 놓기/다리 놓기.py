def multiple(num):
    ans = 1
    for i in range(1, num+1):
        ans *= i
    return ans

T = int(input())
for _ in range(T):
    a, b = map(int, input().split())
    result = multiple(b) // (multiple(b-a) * multiple(a))
    print(result)