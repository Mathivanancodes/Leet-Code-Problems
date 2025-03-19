class Solution {

    public int minOperations(int[] nums) {
        Deque<Integer> flipQueue = new ArrayDeque<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!flipQueue.isEmpty() && i > flipQueue.peekFirst() + 2) {
                flipQueue.pollFirst();
            }

            if ((nums[i] + flipQueue.size()) % 2 == 0) {
                if (i + 2 >= nums.length) {
                    return -1;
                }
                count++;
                flipQueue.offerLast(i);
            }
        }

        return count;
    }
}