y, x = [], []
n = int(input())

for _ in range(n):
    a, b = map(int, input().split())
    y.append(a)
    x.append(b)
y.append(y[0])
x.append(x[0])

ry, rx = 0, 0
for i in range(n):
    ry += y[i] * x[i+1]
    rx += x[i] * y[i+1]

print(round(abs((ry-rx)/2),1))