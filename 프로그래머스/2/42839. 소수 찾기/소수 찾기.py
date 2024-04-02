from itertools import permutations

def solution(numbers):
    nums = [n for n in numbers]
    per = []

    for i in range(1, len(nums)+1):
        per += list(permutations(nums, i))
    new_nums = [int(("").join(p)) for p in per]
    answer = []

    for num in new_nums:
        if num < 2:
            continue
        flag = True
        for i in range(2, int(num**0.5)+1):
            if num % i == 0:
                flag = False
                break
        if flag:
            answer.append(num)
    print(new_nums)
    print(answer)
    return len(set(answer))