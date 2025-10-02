class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int bottleDrunk = numBottles;
        int emptyBottles = numBottles;

        while (emptyBottles >= numExchange) {
            emptyBottles -= numExchange; // use empties for exchange
            numExchange++;               // cost of exchange increases
            bottleDrunk++;               // got one more bottle
            emptyBottles++;              // the new bottle becomes empty
        }
        return bottleDrunk;
    }
}