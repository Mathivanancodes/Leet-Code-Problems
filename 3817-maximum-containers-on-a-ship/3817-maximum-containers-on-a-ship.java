class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        return (n*n > maxWeight/w) ? maxWeight / w : n*n;
    }
}