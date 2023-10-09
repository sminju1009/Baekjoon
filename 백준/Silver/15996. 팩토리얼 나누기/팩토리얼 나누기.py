# 출처 https://highlaw00-dev.tistory.com/27
n, a = map(int, input().split())

def number(num1, num2):
    count = 0
    while num1//num2!=0:
        num1 //= num2
        count += num1
    return count

print(number(n, a))