n, m = map(int, input().split())
arr_a = list(map(int, input().split()))
arr_b = list(map(int, input().split()))

arr = arr_a + arr_b
arr.sort()
print(*arr)