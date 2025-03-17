class Solution {
    public boolean divideArray(int[] nums) {
        int maxNum = 0;
        for (int num: nums){
            maxNum = Math.max(num, maxNum);
        }
        boolean[] needsPair = new boolean[maxNum + 1];
        for(int num : nums){
            needsPair[num] = !needsPair[num];
        }
        for( int num : nums){
            if(needsPair[num]){
                return false;
            }
        }
        return true;
    }
}