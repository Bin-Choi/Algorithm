def solution(prices):
    n = len(prices)
    maxTime = [i for i in range(n-1, -1, -1)]
    stk = [0]

    for i in range (1, n, 1):
        while stk and prices[stk[-1]] > prices[i]:
            j = stk.pop()
            maxTime[j] = i-j
        stk.append(i)
        
    return maxTime