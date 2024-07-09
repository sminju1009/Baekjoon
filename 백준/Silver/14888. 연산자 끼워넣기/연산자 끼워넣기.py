def dfs(level, current_res):
    if level == n:
        ans.append(current_res)
        return
    
    for i in range(4):
        if calc[i] > 0:
            next_res = current_res
            calc[i] -= 1
            
            if i == 0:  # 덧셈
                next_res += arr[level]
            elif i == 1:  # 뺄셈
                next_res -= arr[level]
            elif i == 2:  # 곱셈
                next_res *= arr[level]
            elif i == 3:  # 나눗셈
                if next_res < 0:
                    next_res = -(-next_res // arr[level])
                else:
                    next_res //= arr[level]
            
            dfs(level + 1, next_res)
            calc[i] += 1

n = int(input())
arr = list(map(int, input().split()))
calc = list(map(int, input().split()))
ans = []

dfs(1, arr[0])

print(max(ans))
print(min(ans))