def solution(s):
    flag = True
    n = len(s)
    left = []
    right = []
    # 처음에 )가 들어간 경우 = false
    if s[0]==')':
        return False
    
    for i in range(n):
        if s[i]=='(' and len(left)>=len(right):
            left.append(s[i])
        elif s[i]=='(' and len(left)<len(right):
            flag = False
            break
        elif s[i]==')' and len(left)>len(right):
            right.append(s[i])
        elif s[i]==')' and len(left)<=len(right):
            flag = False
            break
    
    if len(right)!=len(left):
        flag = False
        
        
    return flag