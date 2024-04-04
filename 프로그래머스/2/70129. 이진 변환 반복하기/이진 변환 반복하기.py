def solution(s):
    cnt, zero = 0, 0
    while len(s) > 1:
        before = len(s)
        s = s.replace('0', '')
        after = len(s)
        cnt += 1
        zero += (before-after)
        s = format(after, 'b')

    return [cnt, zero]