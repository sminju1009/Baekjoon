def mul(num1, num2):
    temp = 0

    while num2:
        temp = num1%num2
        num1 = num2
        num2 = temp
    return num1

n = int(input())
for i in range(n):
    a, b = map(int, input().split())
    print(int(a*b/mul(a, b)))