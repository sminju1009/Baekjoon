import math

def lcm(num1, num2):
    return num1 // math.gcd(num1, num2) * num2

def solution(n, m):
    answer = []
    answer.append(math.gcd(n, m))
    answer.append(lcm(n, m))
    return answer