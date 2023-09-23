# 9012 괄호
n = int(input())

for i in range(n):
    stack = []
    a = list(input())

    for j in range(len(a)):
        if not stack:
            stack.append(a[j])
        elif stack[-1]=="(" and a[j]==')':
            stack.pop()
        else:
            stack.append(a[j])

    if not stack:
        print('YES')
    else:
        print('NO')