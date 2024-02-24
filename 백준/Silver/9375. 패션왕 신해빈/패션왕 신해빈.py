n = int(input())
for _ in range(n):
    a = int(input())
    clothes = dict()
    for i in range(a):
        name, kind = input().split()
        if clothes.get(kind)==None:
            clothes[kind] = set()
        clothes[kind].add(name)
        
    count = 1
    for key in clothes.keys():
        count *= len(clothes[key]) + 1
    print(count-1)