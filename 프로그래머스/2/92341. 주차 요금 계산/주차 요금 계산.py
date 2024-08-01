from math import ceil

def solution(fees, records):
    
    def dateToMinutes(date):
        h, m = map(int, date.split(':'))
        return h*60 + m
    
    free, basic, d_time, cost = fees
    
    dic = {}   
    answer = []
    
    for record in records:
        date, car, history = record.split()
        time = dateToMinutes(date)
        car = int(car)
        
        if car not in dic:
            dic[car] = [0, time, history]
        else:
            if history == 'IN':
                dic[car][1], dic[car][2] = time, history
            else:
                dic[car][0] += (time - dic[car][1])
                dic[car][1], dic[car][2] = time, history
    
    for k, v in dic.items():
        if v[-1] == 'IN':
            v[0] += (1439 - v[1])
        f = basic
        if v[0] > free:
            f += ceil((v[0]-free)/d_time) * cost
        answer.append([k,f])
    
    answer = sorted(answer)
    
    return [value[1] for value in answer]