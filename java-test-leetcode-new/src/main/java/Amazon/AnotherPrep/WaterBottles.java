package Amazon.AnotherPrep;

public class WaterBottles {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int count = 0;
        int emptyNotUsed = 0;
        while (numBottles >= 1){
            count += numBottles;

            numBottles += emptyNotUsed;

            emptyNotUsed = numBottles % numExchange;

            numBottles = (numBottles - emptyNotUsed) / numExchange;
        }
        return count + numBottles;
    }

    public static void main(String[] args) {
        System.out.println(numWaterBottles(15, 4));
    }
    /**
     There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water bottles from the market with one full water bottle.

     The operation of drinking a full water bottle turns it into an empty bottle.

     Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.


     * */
}
