tc = int(input())
for _ in range(tc):
    n = int(input())
    
    # 최댓값 구하기
    maxi = ""
    if n % 2 == 0:
        maxi = "1" * (n // 2)
    else:
        maxi = "7" + "1" * (n // 2 - 1)
    
    # 최솟값 구하기
    mini = [""] * 101  # 최대 100자리까지 미리 계산
    nums = ["0", "0", "1", "7", "4", "2", "0", "8"]
    specials = ["", "", "1", "7", "4", "2", "6", "8"]
    
    for i in range(2, 8):
        mini[i] = specials[i]
    
    for i in range(8, n + 1):
        mini[i] = "8" * 100  # 임시 큰 값
        for j in range(2, 8):
            if mini[i - j] != "":
                candidate = mini[i - j] + nums[j]
                if int(candidate) < int(mini[i]):
                    mini[i] = candidate
    
    # 맨 앞에 불필요한 0을 제거
    result = mini[n].lstrip('0')
    if result == "":
        result = "0"
    
    print(result, maxi)