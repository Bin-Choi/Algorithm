from collections import deque

def solution(bridge_length, weight, truck_weights):
    
    time = 0
    bridge = deque([0]*bridge_length)
    trucks = deque(truck_weights)
    bridge_w = 0
    
    while trucks:
        time += 1
        bridge_w -= bridge.popleft()
        
        if weight >= (bridge_w + trucks[0]):
            bridge_w += trucks[0]
            bridge.append(trucks.popleft())
            
        else:
            bridge.append(0)
        
    time += bridge_length
    
    return time
        