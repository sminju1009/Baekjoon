s = list(input())
n = len(s)
stack = []
flag = 0 # 태그와 단어를 구분할 flag => 단어는 0, 태그는 1

arr = ''
for i in range(n):
    if s[i]=='<':
        stack.append(arr[::-1])
        arr = ''
        flag = 1
        stack.append(s[i])
    # tag를 stack 배열에 담기
    if flag==0 and s[i]==' ':
        stack.append(arr[::-1])
        stack.append(s[i])
        arr = ''
    elif flag==0 and s[i]!=' ':
        arr += s[i]
        if i==n-1:
            stack.append(arr[::-1])

    if flag==1 and s[i]!='<':
        if s[i]!='>':
            stack.append(s[i])
        elif s[i]=='>':
            stack.append(s[i])
            flag = 0

print(*stack, sep = "", end="")