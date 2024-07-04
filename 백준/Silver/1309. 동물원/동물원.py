n = int(input())
n1 = n2 = n0 = 1
for i in range(1, n):
    n0, n1, n2 = (n0+n1+n2)%9901, (n0+n2)%9901, (n0+n1)%9901
ans = n0+n1+n2
print(ans%9901)