from itertools import combinations_with_replacement

def solution(n, info):
    lion_scores = []
    LENGTH = 11
    
    for elements in combinations_with_replacement(range(LENGTH), n):
        peach_score = 0
        lion_score = 0
        lion_info = [0] * LENGTH
        
        for idx in elements:
            lion_info[10 - idx] += 1
        
        for i in range(LENGTH):
            if info[i] == 0 and lion_info[i] == 0:
                continue
            elif info[i] >= lion_info[i]:
                peach_score += (10-i)     
            else:
                lion_score += (10-i)
                
        diff = lion_score - peach_score
        
        if diff > 0:
            lion_scores.append((diff, lion_info[::-1]))
        
    lion_scores.sort(key=lambda x: (x[0], x[1]), reverse = True)
    
    if len(lion_scores)==0:
        return [-1]    
    return lion_scores[0][1][::-1]