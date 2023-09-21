# 백준 9251

def lcs(s1, s2):
    len1, len2 = len(s1), len(s2)
    arr = [[0]*(len2+1) for _ in range(len1+1)]
    for i in range(1, len1+1):
        for j in range(1, len2+1):
            if s1[i-1]==s2[j-1]:                # 비교하는 문자가 같다면
                arr[i][j] = arr[i-1][j-1]+1
            else:
                arr[i][j] = max(arr[i][j-1], arr[i-1][j])

    return arr[-1][-1]

s1 = input()
s2 = input()

print(lcs(s1, s2))