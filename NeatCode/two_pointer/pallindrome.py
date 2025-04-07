s = "Was it a car or a cat I saw?"

s = s.replace(" ","").lower()

s = "".join(s for i in s if s.isalnum())

print(s)

print(s==s[::-1])
