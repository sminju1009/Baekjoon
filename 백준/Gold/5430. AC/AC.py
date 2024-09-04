t = int(input())
for i in range(t):
    flag = True
    func = input() # 함수 입력받기
    n = int(input()) # 배열 길이
    temp = input()[1:-1].split(",")
    is_reversed = False
    for j in range(len(func)):
        if func[j]=='R':
            if is_reversed==False:
                is_reversed = True
            else:
                is_reversed = False
        elif func[j]=="D":
            if temp==[''] or not temp:
                flag = False
                break
            else:
                if is_reversed==False:
                    temp.pop(0)
                else:
                    temp.pop(-1)

    if flag==False:
        print("error")
    else:
        if is_reversed:
            temp.reverse()
        str = "["
        for k in range(len(temp)):
            if k!=len(temp)-1:
                str += temp[k]
                str += ","
            else:
                str += temp[k]
        str+="]"
        print(str)