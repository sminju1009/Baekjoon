n = int(input())
money = list(map(int, input().split()))
max_money = int(input())

start, end = 0, max(money)

while start <= end:
    mid = (start + end) // 2

    now_money = 0
    for i in money:
        if i <= mid:
            now_money += i
        else:
            now_money += mid 

    if now_money <= max_money:
        start = mid + 1
        result = mid
    else:
        end = mid - 1

print(result)