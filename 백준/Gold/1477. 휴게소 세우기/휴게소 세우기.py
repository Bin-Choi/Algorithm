N, M, L = map(int, input().split())
arr = [0] + list(map(int, input().split())) + [L]
arr.sort()

s, e = 1, L
ans = 0

while s <= e:
    cnt = 0
    mid = (s+e) // 2

    for i in range(1, len(arr)):
        if arr[i] - arr[i-1] > mid:
            cnt += (arr[i] - arr[i-1] - 1) // mid

    if cnt > M:
        s = mid + 1
    else:
        e = mid - 1
        ans = mid

print(ans)