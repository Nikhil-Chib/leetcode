class Solution {
    public int numDecodings(String s) {
        int[] nums = new int[s.length()+1];
        nums[s.length()] = 1;
        
        for(int i=s.length()-1; i>=0; i--) {
            int sum = 0;
            
            if(s.charAt(i) == '0') {
                nums[i] = 0;
                continue;
            }
            
            sum += nums[i+1];
            if(i+1 < s.length() && Integer.parseInt(s.substring(i, i+2)) <= 26) {
                sum += nums[i+2];
            }
            
            nums[i] = sum;
        }
        return nums[0];
    }
    
//     public int numDecodings(String s, int si) {
        
//         int sum = 0;
//         if(si >= s.length()) {
//             return 1;
//         }
        
//         if( s.charAt(si) == '0') {
//             return 0;
//         }
        
//         sum+= numDecodings(s, si+1);
//         if(si+1 < s.length() && Integer.parseInt(s.substring(si, si+2)) <= 26 ) {
//             sum+= numDecodings(s, si+2);
//         }
        
//         return sum;
//     }
}