N, M = map(int, input().split())
arr = []
for _ in range(N):
    arr.append(int(input()))

arr.sort()
Min = int(2e9)

s, e = 0, 0

while s <= e < N:

    if arr[e] - arr[s] < M:
        e += 1

    else:
        Min = min(Min, arr[e]-arr[s])
        s += 1

print(Min)