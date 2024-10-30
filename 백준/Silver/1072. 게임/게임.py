x, y = map(int, input().split())
z = (100*y)//x
start, end = 0, x
res = x

if z>=99:
    print(-1)
else:
    while start<=end:
        mid = (start+end)//2
        if (100*(y+mid))//(x+mid)>z:
            res = mid
            end = mid-1
        else:
            start = mid+1
    print(res)