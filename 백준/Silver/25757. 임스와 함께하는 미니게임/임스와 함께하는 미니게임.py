from collections import defaultdict

dic = defaultdict(int)
count = 0
n, game = input().split()
n = int(n)
for i in range(n):
    a = input()
    if dic[a] != 1:
        count += 1
        dic[a] = 1

if game=="Y":
    print(count)
elif game=="F":
    print(count//2)
elif game=="O":
    print(count//3)