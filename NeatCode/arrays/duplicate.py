class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        nums.sort()
        hashmap=[]

        for i in nums:
            if i in hashmap:
                return True
            hashmap.append(i)
        return False
