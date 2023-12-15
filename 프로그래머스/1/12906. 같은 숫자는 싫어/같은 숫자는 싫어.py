def solution(arr):
    stack = []
    for i in range(len(arr)):
        # 스택이 비어있을 때
        if len(stack)==0:
            stack.append(arr[i])
        # 스택이 비어있지 않을 때
        elif i>=1 and len(stack)!=0:
            if arr[i-1]!=arr[i]:
                stack.append(arr[i])
            
    return stack
            