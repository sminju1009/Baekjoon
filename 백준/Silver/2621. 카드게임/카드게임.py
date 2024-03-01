cnt_color = {'R':0, 'G':0, 'B':0, 'Y':0}
cnt_num = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
nums = []

for i in range(5):
    color, num = input().split()
    num = int(num)
    cnt_color[color] += 1
    cnt_num[num] += 1
    nums.append(num)

score = 0
# case 1, 4 구하기
if 5 in cnt_color.values():
    nums.sort()
    # case 1
    if nums[1]==nums[0]+1 and nums[2]==nums[1]+1 and nums[3]==nums[2]+1 and nums[4]==nums[3]+1:
        score = 900+max(nums)
    # case 4
    else:
        score = 600+max(nums)
# case 2 구하기
elif 4 in cnt_num:
    score = 800+cnt_num.index(4)
# case 3, 6 구하기
elif 3 in cnt_num:
    # case 3
    if 2 in cnt_num:
        score = cnt_num.index(3)*10+cnt_num.index(2)+700
    # case 6
    else:
        score = cnt_num.index(3)+400
# case 7, 8 구하기
elif 2 in cnt_num:
    cnt = []
    for i in range(1, 10):
        if cnt_num[i]==2:
            cnt.append(i)
    # case 7
    if len(cnt)==2:
        score = max(cnt)*10+min(cnt)+300
    else:
        score = cnt[0]+200

# case 5, 9 구하기
elif cnt_num.count(1)==5:
    # case 5
    nums.sort()
    if nums[1]==nums[0]+1 and nums[2]==nums[1]+1 and nums[3]==nums[2]+1 and nums[4]==nums[3]+1:
        score = max(nums) + 500
    else:
        score = max(nums) + 100

print(score)