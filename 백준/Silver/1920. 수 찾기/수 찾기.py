import sys
input = sys.stdin.readline

n = int(input())
arr1 = sorted(list(map(int, input().split())))
m = int(input())
arr2 = list(map(int, input().split()))

def binary_search(start, end, target):
    while start<=end:
        mid = (start+end)//2

        if arr1[mid]==target:
            return 1
        elif arr1[mid]>target:
            end = mid-1
        elif arr1[mid]<target:
            start = mid+1
    return 0

for i in range(m):
    ans = binary_search(0, n-1, arr2[i])
    print(ans)