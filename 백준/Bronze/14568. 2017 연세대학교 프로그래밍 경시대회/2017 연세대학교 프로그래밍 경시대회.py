# 백준 14568

n = int(input())

a = []
b = []
c = []

for i in range(2, n+1, 2):
    for j in range(1, n+1-i):
        for k in range(1, n+1-i-j):
            if k>=j+2 and i+j+k==n:
                a.append(i)
                b.append(j)
                c.append(k)

print(len(a))