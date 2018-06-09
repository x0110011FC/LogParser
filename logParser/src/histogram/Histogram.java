package histogram;

import java.util.Map;

public class Histogram {

    public Histogram(){}

    public static void displayHistogram(Map<Integer, Long> aggregatedData){
        System.out.println("\nHours");
        for (int i = 23; i >= 0; i--) {
            System.out.println(i);
            if (aggregatedData.containsKey(i)) {
                for (int j = 0; j < aggregatedData.get(i) / 100; j++) {
                    System.out.print("*");
                }
                System.out.print(" " + aggregatedData.get(i) + " total requests");
            }
            System.out.println();
        }
        System.out.println("Number of requests (n / 100)");
    }
}
