def dfs(num, level, visited):
    if level==k:
        if "".join(num) not in numbers:
            numbers.append("".join(num))
        return
    for i in range(n):
        if visited[i]==0:
            num.append(cards[i])
            visited[i] = 1
            dfs(num, level+1, visited)
            num.pop()
            visited[i] = 0

cards = []
n = int(input())
k = int(input())
for _ in range(n):
    cards.append(input())
numbers = [] # 만들어진 숫자들이 들어갈 배열
visited = [0] * n
dfs([], 0, visited)
print(len(numbers))