t = int(input())
arr = []
for i in range(t):
    r, s = input().split()
    r = int(r)
    arr.append([r, s])

for i in range(t):
    for j in range(len(arr[i][1])):
        print(arr[i][1][j] * arr[i][0], end="")
    print()
