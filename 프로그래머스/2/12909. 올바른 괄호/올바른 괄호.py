def solution(s):
    stk = []
    for char in s:
        if not stk:
            if char == ')':
                return False
            stk.append(char)
            
        elif char == '(':
            stk.append(char)
        
        elif char == ')':
            if stk[-1] == '(':
                stk.pop()
            else:
                stk.append(char)
    
    if stk:
        return False
    return True