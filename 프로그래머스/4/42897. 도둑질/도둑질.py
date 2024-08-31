def solution(money):
    n = len(money)
    
    if n == 1:
        return money[0]
    
    # 첫 번째 집을 터는 경우 (마지막 집은 안 턴다)
    dp1 = [0] * n
    dp1[0] = money[0]
    dp1[1] = max(money[0], money[1])
    
    for i in range(2, n-1):  # n-1번째 집까지 가능
        dp1[i] = max(dp1[i-1], dp1[i-2] + money[i])
    
    # 첫 번째 집을 털지 않는 경우 (마지막 집을 털 수 있음)
    dp2 = [0] * n
    dp2[1] = money[1]
    
    for i in range(2, n):
        dp2[i] = max(dp2[i-1], dp2[i-2] + money[i])
    
    # 두 경우 중 큰 값을 반환
    return max(dp1[-2], dp2[-1])
