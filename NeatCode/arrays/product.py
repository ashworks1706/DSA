num = [-1,0,1,2,3]
result=[]
for i in nums:
    prod=1
    for j in nums:
        if j!=i:
            prod*=j
    result.append(prod)
print(result)
