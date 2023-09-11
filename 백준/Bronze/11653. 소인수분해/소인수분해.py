n = int(input())

if n==1:            # 1인 경우
    print('')
else:               # 1이 아닌 경우
    for i in range(2, n+1):
        if n%i==0:
            while n%i==0:
                print(i)
                n = n//i