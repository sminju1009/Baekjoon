t = int(input())
arr = [0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9]
arr = arr + [0] * 90

for i in range(11, 101):
    arr[i] = arr[i-5] + arr[i-1]

for tc in range(t):
    n = int(input())
    print(arr[n])