import sys
input = sys.stdin.readline

def dots_min(a):
    start, end = 0, n-1
    while start<=end:
        mid = (start+end)//2
        if a>arr[mid]:
            start = mid+1
        else:
            end = mid-1
    return end+1

def dots_max(a):
    start, end = 0, n-1
    while start<=end:
        mid = (start+end)//2
        if a>=arr[mid]:
            start = mid+1
        else:
            end = mid-1
    return end

n, m = map(int, input().split())
arr = sorted(list(map(int, input().split())))
for _ in range(m):
    s, e = map(int, input().split())
    print(dots_max(e) - dots_min(s) + 1)