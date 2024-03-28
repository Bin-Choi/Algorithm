def solution(s):
    stk = []
    for c in s:
        if c == '(':
            stk.append(c)
        
        if c == ')':
            
            if stk:
                stk.pop()
                
            else:
                return False
                
    return len(stk) == 0