numbers = [1,2,3,4]
target = 3

b ={}

for index,value in enumerate(numbers):
    print(value,index)

    if value not in b:
        b[value] = index

    if target-value in b:
        print([b[target-value]+1,index+1])
        break

