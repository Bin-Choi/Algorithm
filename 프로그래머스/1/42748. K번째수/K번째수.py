def solution(array, commands):
    answer = []
    for command in commands:
        i, j, k = command[0]-1, command[1], command[2]-1
        arr = sorted(array[i:j])
        answer.append(arr[k])

    return answer