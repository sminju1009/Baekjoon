n, m = map(int, input().split())

res = (m+1)*m//2
arr = [0]*res

for i in range(1, m+1):
    for j in range((i-1)*i//2, (i+1)*i//2):
        arr[j] = i

print(sum(arr[n-1:m]))