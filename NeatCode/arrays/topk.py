nums = [1,1,1,2,2,3]
k=2
freq_map = {}
for num in nums:
    freq_map[num] = freq_map.get(num, 0) + 1    

print(sorted(freq_map.keys(), key=lambda x: freq_map[x], reverse=True)[:k])

