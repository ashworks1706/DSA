# Input: tokens = ["1","2","+","3","*","4","-"]

# Output: 5

# Explanation: ((1 + 2) * 3) - 4 = 5

tokens = ["1","2","+","3","*","4","-"]

eq=[]
res=0

for token in tokens:
    if token in {"+", "-", "*", "/"}:
        b = stack.pop()        
        a = stack.pop() 
        
        if token == "+":
            result = a + b
        elif token == "-":
            result = a - b
        elif token == "*":
            result = a * b
        elif token == "/":
            result = int(a / b)
        
        stack.append(result)
    else:
        stack.append(int(token))

print(res)
