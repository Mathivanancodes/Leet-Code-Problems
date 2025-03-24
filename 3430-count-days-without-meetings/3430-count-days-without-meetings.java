class Solution {

    public int countDays(int days, int[][] meetings) {
        TreeMap<Integer, Integer> dayMap = new TreeMap<>();
        int prefixSum = 0, freeDays = 0, previousDay = days;
        boolean hasGap = false;

        for (int[] meeting : meetings) {
            previousDay = Math.min(previousDay, meeting[0]);
            dayMap.put(meeting[0], dayMap.getOrDefault(meeting[0], 0) + 1);
            dayMap.put(
                meeting[1] + 1,
                dayMap.getOrDefault(meeting[1] + 1, 0) - 1
            );
        }
        freeDays += (previousDay - 1);
        for (Map.Entry<Integer, Integer> day : dayMap.entrySet()) {
            int currentDay = day.getKey();
            if (prefixSum == 0) {
                freeDays += (currentDay - previousDay);
            }
            prefixSum += day.getValue();
            previousDay = currentDay;
        }
        freeDays += days - previousDay + 1;
        return freeDays;
    }
}