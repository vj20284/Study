"""
Given integer array nums, return the third maximum number in this array. 
If the third maximum does not exist, return the maximum number.
"""
class Solution:
    MINVAL = -2**31

    def thirdMax(self, nums: list[int]) -> int:
        v = [float('-inf'), float('-inf'), float('-inf')]
        for num in nums:
            if num not in v:
                if num > v[0]:   v = [num, v[0], v[1]]
                elif num > v[1]: v = [v[0], num, v[1]]
                elif num > v[2]: v = [v[0], v[1], num]
        return max(nums) if float('-inf') in v else v[2]

if __name__ == "__main__":
    s = Solution()

    nums = [1, 2, 3]
    print(s.thirdMax(nums))

    nums = [1, 2]
    print(s.thirdMax(nums))

    nums = [3, 2, 0]
    print(s.thirdMax(nums))

    nums = [4, 1, 2, 3]
    print(s.thirdMax(nums))

    nums = [2, 2, 3, 1] 
    print(s.thirdMax(nums))

    nums = [1, 1, 2] 
    print(s.thirdMax(nums))