import sys

n = int(sys.stdin.readline())
stack = []
for i in range(n):
    a = sys.stdin.readline().split()
    # push일때
    if 'push' in a:
        a[1] = int(a[1])
        stack.append(a[1])
    # pop일때
    elif a[0]=='pop':
        if len(stack)==0:
            print(-1)
        else:
            print(stack.pop())
    # size 일때
    elif a[0]=='size':
        print(len(stack))
    # empty일때
    elif a[0]=='empty':
        if len(stack)==0:
            print(1)
        else:
            print(0)
    # top일때
    elif a[0]=='top':
        if len(stack)==0:
            print(-1)
        else:
            print(stack[-1])