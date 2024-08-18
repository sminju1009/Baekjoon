stack = []
cnt = 1
result = [] # 출력해야 하는 결과물
status = True

n = int(input())
for i in range(n):
    a = int(input())
    while cnt<=a:
        stack.append(cnt)
        result.append("+")
        cnt += 1
    if stack[-1]==a:
        stack.pop()
        result.append("-")
    else:
        status = False
        print("NO")
        break

if status:
    for i in result:
        print(i)