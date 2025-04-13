# Example 1:

# Input: n = 1

# Output: ["()"]
# Example 2:

# Input: n = 3

# Output: ["((()))","(()())","(())()","()(())","()()()"]

stack=[]
res=[]
n=3
def recursion(open:int, closed:int):
    if open==closed==n:
        res.append("".join(stack))
        return 
    elif open<n:
        stack.append("(")
        recursion(open+1,closed)
        stack.pop()
    elif closed<open:
        stack.append(")")
        recursion(open,closed+1)
        stack.pop()

recursion(0,0)

print(res)
