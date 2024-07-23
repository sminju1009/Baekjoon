def gcd(args):
    def _gcd(n, m):
        while m > 0:
            n, m = m, n % m
        return n
    if len(args) < 2:
        return args[0]
    else:
        n = args[0]
        for m in args[1:]:
            n = _gcd(n, m)
        return n

def solution(arrayA, arrayB):
    def func(array1, array2):
        gcd_value = gcd(array1)
        for i in array2:
            if i % gcd_value == 0:
                return 0
        return gcd_value
    
    resultA = func(arrayA, arrayB)
    resultB = func(arrayB, arrayA)

    return max(resultA, resultB)