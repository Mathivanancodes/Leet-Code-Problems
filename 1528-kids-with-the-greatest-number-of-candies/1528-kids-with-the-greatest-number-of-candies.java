class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for(int candy : candies){
            maxCandies = Math.max(maxCandies, candy);
        }
        List<Boolean> result = new ArrayList<>();
        for(int candy : candies){
            if(candy + extraCandies >= maxCandies){
                result.add(true);
            } else{
                result.add(false);
            }
        }
        return result;
    }
}