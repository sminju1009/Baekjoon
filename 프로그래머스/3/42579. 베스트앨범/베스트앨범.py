from collections import defaultdict

def solution(genres, plays):
    answer = []
    total = defaultdict(int)
    gen_dic = defaultdict(list)
    
    for i in range(len(genres)):
        genre = genres[i]
        play = plays[i]
        
        total[genre] += play
        gen_dic[genre].append((play, i))

    total = sorted(total.items(), key=lambda x: x[1], reverse=True)
    
    for key in total:
        playlist = gen_dic[key[0]]
        playlist = sorted(playlist, key=lambda x:x[0], reverse=True)
        for i in range(len(playlist)):
            if i==2:
                break
            answer.append(playlist[i][1])
    
    return answer