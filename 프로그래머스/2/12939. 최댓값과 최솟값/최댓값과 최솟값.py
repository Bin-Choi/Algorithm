def solution(s):
    nums = list(map(int, s.split(" ")))
    MIN = min(nums)
    MAX = max(nums)
    return str(MIN) + " " + str(MAX)