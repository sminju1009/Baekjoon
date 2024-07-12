def find_parent(parent, x):
    if parent[x]!=x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a<b:
        parent[b] = a
    else:
        parent[a] = b

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

parent = [0] * (n+1)
edges = []
result = 0

for i in range(1, n+1):
    parent[i] = i

for i in range(n-1):
    for j in range(i+1, n):
        edges.append((arr[i][j], i, j))

edges.sort()

for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost

print(result)