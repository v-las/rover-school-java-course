package lectures.lecture008;

import static lectures.lecture008.SellingCars.forSaleAd;

public class Main {
    public static void main(String[] args) {
        int[] temps = {43, 32, 12, 11};
        HottestDays hottestDays = getTwoHottestDays(temps);
        System.out.println("hottestDays = " + hottestDays.hottestTemp);
        System.out.println("secondHottestTemp = " + hottestDays.secondHottestTemp);
    }

    public static HottestDays getTwoHottestDays(int[] temps) {
        int hottest = Integer.MIN_VALUE;
        int secondHottest = Integer.MIN_VALUE;

        for (int currentDayTemp : temps) {
            if (currentDayTemp > hottest) {
                secondHottest = hottest;
                hottest = currentDayTemp;
            } else if (currentDayTemp > secondHottest) {
                secondHottest = currentDayTemp;
            }
        }

        HottestDays result = new HottestDays();
        result.hottestTemp = hottest;
        result.secondHottestTemp = secondHottest;

        return result;
    }

    static class HottestDays {
        public int hottestTemp;
        public int secondHottestTemp;
    }

}
