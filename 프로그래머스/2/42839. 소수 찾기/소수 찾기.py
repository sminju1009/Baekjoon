from itertools import permutations

# 1. 소수인지 구하는 함수 짜기
def isPrime(num):
    if num<2:
        return 0
    for i in range(2, num):
        if num%i==0:
            return 0
    return 1

def solution(numbers):
    # 2. 숫자 계산
    nums = list(numbers)     # 종이조각으로 바꾸는 것
    per = []
    for i in range(1, len(numbers) + 1):
        per += list(permutations(nums, i))
    new_nums = [int(("").join(p)) for p in per]
    
    new_nums = set(new_nums)
    
    cnt = 0
    for n in new_nums:
        if isPrime(n)==1:
            cnt += 1
    
    return cnt