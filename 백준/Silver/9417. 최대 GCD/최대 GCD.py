n = int(input())

def count(a, b):
    while b != 0:
        [a, b] = [b, a%b]
    return a

for i in range(n):
    arr = list(map(int, input().split()))
    # 유클리드 호제법을 실행하기 위해 정렬한다.
    arr.sort()

    # 가장 큰 최대 공약수를 저장할 변수
    maxi = 0
    # 유클리드 호제법 실행하기
    for j in range(len(arr)):
        for k in range(j+1, len(arr)):
            res = count(arr[j], arr[k])
            if res>maxi:
                maxi = res
    print(maxi)