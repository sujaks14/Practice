package test.Array;

import java.util.ArrayList;
import java.util.List;

public class StockBuySell {

/**
The cost of a stock on each day is given in an array,
find the max profit that you can make by buying and selling in those days.
 */


    public static void main(String[] args) {
        System.out.println("Enters main");
        oneTransaction();
      multipleTransactionsNotOnSameDay();
        stockBuySell();


    }


    private static void multipleTransactionsNotOnSameDay() {
        /**
         Design an algorithm to find the maximum profit.
         You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
         However, you may not engage in multiple transactions at the same time
         (ie, you must sell the stock before you buy again).
         */
        int[] prices = new int[]{100, 180, 260, 310, 40, 535, 695};
        /**
         Buy on day : 0   Sell on day: 3
         Buy on day : 4   Sell on day: 6

         -100 +310 -40 +695

         */
        int maxSoFar = 0;
        List<Integer> buyList = new ArrayList<>();
        List<Integer> sellList = new ArrayList<>();

        int lastSold = -1;
        for(int i=1; i <  prices.length; i++) {
            if(prices[i] >prices[i-1]) {
                maxSoFar += (prices[i] - prices[i - 1]);
//                buyList.add(i-1);
//                sellList.add(i);
            }

        }
        System.out.println("maxSoFar: " + maxSoFar);
//        System.out.println("Buy List");
//        buyList.stream().forEach(b-> System.out.println(b));
//        System.out.println("sell List");
//        sellList.stream().forEach(s-> System.out.println(s));

        /**
         Buy on day : 0   Sell on day: 3
         Buy on day : 4   Sell on day: 6
         */
    }

    static class Interval
    {
        int buy, sell;
    }

    static void stockBuySell()
    {
        int[] price = new int[] {100, 180, 260, 310, 40, 535, 695};
        int n = price.length;

        // Prices must be given for at least two days
        if (n == 1)
            return;

        int count = 0;

        // solution array
        ArrayList<Interval> sol = new ArrayList<Interval>();

        // Traverse through given price array
        int i = 0;
        while (i < n - 1)
        {
            // Find Local Minima. Note that the limit is (n-2) as we are
            // comparing present element to the next element.
            while ((i < n - 1) && (price[i + 1] <= price[i]))
                i++;

            // If we reached the end, break as no further solution possible
            if (i == n - 1)
                break;

            Interval e = new Interval();
            e.buy = i++;
            // Store the index of minima


            // Find Local Maxima.  Note that the limit is (n-1) as we are
            // comparing to previous element
            while ((i < n) && (price[i] >= price[i - 1]))
                i++;

            // Store the index of maxima
            e.sell = i-1;
            sol.add(e);

            // Increment number of buy/sell
            count++;
        }

        // print solution
        if (count == 0)
            System.out.println("There is no day when buying the stock "
                    + "will make profit");
        else
            for (int j = 0; j < count; j++)
                System.out.println("Buy on day: " + sol.get(j).buy
                        +"        " + "Sell on day : " + sol.get(j).sell);

        return;
    }

    private static void oneTransaction() {

        int[] a = new int[] {7, 1, 5, 3, 6, 4};
        int n = a.length;

        int maxDiff = 0;
        for(int i=0;i < n; i++) {
            for(int j=1; j <n; j++){
                maxDiff  =Math.max( (a[j]-a[i]), maxDiff);
            }
        }

        System.out.println("maxDiff: " + maxDiff);


        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i < a.length; i++) {

            if(a[i] < minPrice)
                minPrice = a[i];
            else {
                maxProfit = Math.max(maxProfit, (a[i] - minPrice));
            }
        }
        System.out.println("maxProfit: "  + maxProfit);
    }
}
