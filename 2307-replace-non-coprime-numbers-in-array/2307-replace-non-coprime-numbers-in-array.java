class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        
        for (int num : nums) {
            while (!stack.isEmpty()) {
                int top = stack.get(stack.size() - 1);
                int g = gcd(top, num);
                if (g == 1) {
                    break;
                }
                // merge top with current num (via LCM)
                stack.remove(stack.size() - 1);
                num = (top / g) * num;  // safer LCM
            }
            stack.add(num);
        }
        
        return stack;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}