nums = ["neet","code","love","you"]
enc_str=""
for i in nums:
    enc_str+=f"{len(i)}#{i}"

dec_str=""

i=0

decoded = []
    
while i < len(enc_str):
    j = i
    while j < len(enc_str) and enc_str[j] != '#':
        j += 1
    length = int(enc_str[i:j])       
    decoded.append(enc_str[j+1:j+1+length])
            
    i = j + 1 + length


print(decoded) 
