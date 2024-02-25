from collections import defaultdict

n, m = map(int, input().split())
members = defaultdict(list)
for i in range(n):
    team = input()
    member_count = int(input())
    for j in range(member_count):
        name = input()
        members[team].append(name)

for _ in range(m):
    quiz = input()
    flag = int(input())
    # flag가 0인 경우 팀이름, 1인 경우 멤버 이름이 주어진다.
    if flag==0:
        for key, values in members.items():
            if quiz in key:
                values.sort()
                for j in values:
                    print(j)
                break
    elif flag==1:
        for key, values in members.items():
            if quiz in values:
                print(key)
                break