import math
org = int(input())
test = math.isqrt(org)
if test**2 != org:
    test += 1
print(test)