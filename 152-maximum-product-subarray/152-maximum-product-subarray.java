class Solution {
    public int maxProduct(int[] nums) {
        int maxPositive = 1;
        int minNegative = 1;
        int maxProduct = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i]  >=0 ) {
                maxPositive = Math.max(maxPositive*nums[i], nums[i]);
                minNegative = Math.min(minNegative*nums[i], nums[i]);
            } else {
                int temp = Math.max(minNegative*nums[i], nums[i]);
                minNegative = Math.min(maxPositive*nums[i], nums[i]);
                maxPositive = temp;
            }
            
            maxProduct = Math.max(maxProduct, maxPositive);
        }
        
        return maxProduct;
    }
}