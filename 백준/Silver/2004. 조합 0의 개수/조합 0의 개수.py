n, m = map(int, input().split())

# 곱해진 2의 갯수 카운트하는 함수
def cnt2(num):
    # 2보다 작으면 탐색할 필요가 없어서 0 반환
    if num<2:
        return 0
    # 2의 개수 반환할 cnt 설정
    cnt = 0
    # 탐색 - 2보다 작은 수는 탐색할 필요 없으므로 2부터 탐색함
    while num>=2:
    # cnt값 계속 갱신함.
        cnt += num//2
        num = num//2
    return cnt

# 곱해진 5의 갯수 카운트하는 함수
def cnt5(num):
    # 5보다 작으면 탐색할 필요가 없어서 0 반환
    if num<5:
        return 0
    # 5의 개수 반환할 cnt 설정
    cnt = 0
    # 탐색 - 5보다 작은 수는 탐색할 필요 없으므로 5부터 탐색함
    while num>=5:
    # cnt값 계속 갱신함
        cnt += num//5
        num = num//5
    return cnt

# 2의 갯수
ans1 = cnt2(n)-cnt2(m)-cnt2(n-m)
# 5의 갯수
ans2 = cnt5(n)-cnt5(m)-cnt5(n-m)
# 출력하기
print(min(ans1, ans2))