def hanoi(start, end, mid, num):
    global n
    if num==1:
        print(f'{start} {end}')
    else:
        hanoi(start, mid, end, num-1)
        hanoi(start, end, mid, 1)
        hanoi(mid, end, start, num-1)

n = int(input())
print(2**n-1)
if n<=20:
    hanoi(1, 3, 2, n)