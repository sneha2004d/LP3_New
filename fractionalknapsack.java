import java.util.*;

public class FractionalKnapsack {

    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int capacity = 50;

        int n = value.length;
        double totalValue = 0.0;
        int currentWeight = 0;

        // Step 1: Calculate value/weight ratio for each item
        double[][] ratio = new double[n][2];  // [0] = ratio, [1] = index
        for (int i = 0; i < n; i++)
            ratio[i][0] = (double) value[i] / weight[i];
        
        for (int i = 0; i < n; i++)
            ratio[i][1] = i;

        // Step 2: Sort by ratio (descending order)
        Arrays.sort(ratio, (a, b) -> Double.compare(b[0], a[0]));

        // Step 3: Pick items greedily
        for (int i = 0; i < n; i++) {
            int idx = (int) ratio[i][1];

            if (currentWeight + weight[idx] <= capacity) {
                // take full item
                currentWeight += weight[idx];
                totalValue += value[idx];
            } else {
                // take fractional part
                int remain = capacity - currentWeight;
                totalValue += value[idx] * ((double) remain / weight[idx]);
                break;
            }
        }

        System.out.println("Maximum value in knapsack = " + totalValue);
    }
}
