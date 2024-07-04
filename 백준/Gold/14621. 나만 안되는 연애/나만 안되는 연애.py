def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a<b:
        parent[b] = a
    else:
        parent[a] = b

n, m = map(int, input().split())
parent = [0] * (n+1)
schools = ['No'] + list(input().split())

edges = []
result = 0
path_num = 0

for i in range(1, n+1):
    parent[i] = i

for _ in range(m):
    u, v, d = map(int, input().split())
    edges.append((d, u, v))

edges.sort()

for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b) and schools[a] != schools[b]:
        union_parent(parent, a, b)
        result += cost
        path_num += 1

if path_num==n-1:
    print(result)
else:
    print(-1)