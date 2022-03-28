class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] minCost = new int[days.length];
        minCost[days.length-1] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        for(int i=days.length-2; i>=0; i--) {
            int currMinCost = costs[0] + minCost[i+1];
            int j = 0;
            while(i+j+1 < days.length && days[i+j+1] < days[i]+7) {
                j++;
            }
            currMinCost = Math.min(currMinCost, i+j+1 >= days.length ? 
                                   costs[1] : minCost[i+j+1] + costs[1]);

            while(i+j+1 < days.length && days[i+j+1] < days[i]+30) {
                j++;
            }

            currMinCost = Math.min(currMinCost, i+j+1 >= days.length ? 
                                   costs[2] : minCost[i+j+1] + costs[2]);
            minCost[i] = currMinCost;
        }

        return minCost[0];
    }
}