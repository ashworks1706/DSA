class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        res={}
        for i,e in enumerate(nums):
            diff = target - e
            if diff in res:
                return [res[diff],i]
            else:
                res[e] = i
        return res

