# https://hongcoding.tistory.com/4

import sys
input = sys.stdin.readline

n = int(input())
arr1 = sorted(list(map(int, input().split())))
m = int(input())
arr2 = list(map(int, input().split()))

def binary_search(array, target, start, end):
    while start<=end:
        mid = (start+end)//2

        if array[mid]==target:
            return mid
        elif array[mid]>target:
            end = mid-1
        elif array[mid]<target:
            start = mid+1

    return None

for i in range(m):
    if not binary_search(arr1, arr2[i], 0, n-1) is None:
        print(1, end=' ')
    else:
        print(0, end=' ')