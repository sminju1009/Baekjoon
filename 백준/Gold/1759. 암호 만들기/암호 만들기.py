def dfs(n, cnt, tst):
    if n==C: # 모든 알파벳의 사용여부를 선택한 경우
        # 비밀번호 길이, 모음 개수>=1, 자음개수>=2
        if len(tst)==L and cnt>=1 and L-cnt>=2:
            ans.append(tst)
        return

    dfs(n+1, cnt+tbl[ord(lst[n])], tst+lst[n])# 포함하는 경우
    dfs(n+1, cnt, tst) # 포함하지 않는 경우

L, C = map(int, input().split())
lst = sorted(input().split())
# lookup table(모음인 경우 1, 그외 0이 저장되어 있는)
tbl = [0] * 128
for ch in "aeiou":
    tbl[ord(ch)] = 1

# n(index), cnt = 모음의 개수, tst(완성되는 비밀번호 문자열)
ans = []
dfs(0, 0, "")
for st in ans:
    print(st)