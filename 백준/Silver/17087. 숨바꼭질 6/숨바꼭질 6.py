def gcd(a, b):
    while b:
        mod = b
        b = a%b
        a = mod
    return a

n, s = map(int, input().split())
arr = list(map(int, input().split()))

for i in range(n):
    arr[i] = abs(arr[i]-s)

arr = list(set(arr))
dif = min(arr)

if n==1:
    print(arr[0])
else:
    for i in range(len(arr)):
        dif = gcd(dif, arr[i])
    print(dif)