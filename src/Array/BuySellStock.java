package Array;

public class BuySellStock {
    public static void main(String[] args) {
        BuySellStock bss = new BuySellStock();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(bss.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;

        int buyPrice = prices[0];

        for(int i = 1; i < prices.length; i++) {
            if(buyPrice > prices[i])  {
                buyPrice = prices[i];
            } else {
                int diff = prices[i] - buyPrice;
                profit = Math.max(profit, diff);
            }
        }
        

        return profit;
    }
}
