def solution(numbers, target):
    n = len(numbers)
    answer = 0
    def dfs(level, result):
        if level==n:
            if result==target:
                nonlocal answer
                answer += 1
            return
        else:
            dfs(level+1, result+numbers[level])
            dfs(level+1, result-numbers[level])
    dfs(0, 0)
        
    return answer
    