def solution(cards):
    visited = [0] * len(cards)      # 준비한 카드 수만큼 작은 상자 하나 준비
    
    def dfs(num):
        size = 0
        while not visited[num]:
            visited[num] = 1
            num = cards[num] - 1
            size += 1
        return size
    
    group_sizes = []
    
    for i in range(len(cards)):
        if not visited[i]:
            group_sizes.append(dfs(i))
    
    if len(group_sizes) < 2:
        return 0
    else:
        group_sizes.sort(reverse=True)
        return group_sizes[0] * group_sizes[1]
