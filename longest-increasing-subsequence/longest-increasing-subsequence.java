class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] le = new int[nums.length];
        int ei = 0;
        le[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > le[ei]) {
                ei++;
                le[ei] = nums[i];
            } else if (nums[i] < le[ei]) {
                int index = binarySearch(le, 0, ei, nums[i]);
                le[index] = nums[i];
            }
        }
        
        return ei+1;
    }
    
    public int binarySearch(int[] le, int si, int ei, int ele) {
        
        while(si <= ei) {
            int mid = (si+ei)/2;
            if(ele > le[mid]) {
                si = mid+1;
            } else {
                ei = mid-1;
            }
        }
        
        return si;
    }
}