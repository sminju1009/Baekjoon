# 특정 원소가 속한 집합을 찾기
def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

# 두 원소가 속한 집합을 합치기
def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a<b:
        parent[b] = a
    else:
        parent[a] = b

n, m, k = map(int, input().split())
parent = [0] * (n+1)

for i in range(1, n+1):
    parent[i] = i

# 모든 간선을 담을 리스트와, 최종 비용을 담을 변수
edges = []
result = 0

money = list(map(int, input().split()))
# 모든 간선에 대한 정보를 입력받기
for _ in range(m):
    a, b = map(int, input().split())
    edges.append((0, a, b))

for i in range(n):
    edges.append((money[i], 0, i+1))

edges.sort()

for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a)!=find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost

if result<=k:
    print(result)
else:
    print("Oh no")