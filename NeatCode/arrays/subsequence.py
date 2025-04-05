nums = [2,20,4,10,3,4,5]
if not nums:
    exit(0)

num_set = set(nums)

max_length = 0

for num in num_set:
    if num - 1 not in num_set:
        current_num = num
        current_length = 1
        
        while current_num + 1 in num_set:
            current_num += 1
            current_length += 1
        
        max_length = max(max_length, current_length)
print(max_length) 