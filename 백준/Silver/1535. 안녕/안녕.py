# dfs 이용

def dfs(level, hp, happy):
    global now_hp, now_happy
    if level == n:
        now_happy = max(now_happy, happy)
        return
    dfs(level + 1, hp, happy)
    if hp - minus_hp[level] > 0:
        dfs(level + 1, hp - minus_hp[level], happy + gain_happy[level])

n = int(input())
minus_hp = list(map(int, input().split()))
gain_happy = list(map(int, input().split()))

now_hp = 100 # 주어진 체력
now_happy = 0 # 현재 기쁨

dfs(0, 100, 0)

print(now_happy)