package problem1491;

import java.util.Arrays;

public class problem1491 {

    public static double average(int[] salary) {
        double sum = 0;
        double maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
        for (int num : salary) {
            sum += num;
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
        }
        return (sum - maxValue - minValue) / (salary.length - 2);
    }

    public static double average2(int[] salary) {
        Arrays.sort(salary);
        double sum = 0;
        for (int i = 1; i < salary.length-1; i++) {
            sum +=  salary[i];
        }
        return sum  / (salary.length - 2);
    }

    public static void main(String[] args) {
        int[] salary = new int[10000];
        for (int i = 0; i < 10000; i++) {
            salary[i] = i;
        }
        long start = System.currentTimeMillis();
        System.out.println(average(salary));
        long second = System.currentTimeMillis();
        System.out.println(average2(salary));
        long end = System.currentTimeMillis();
        System.out.println(second - start);
        System.out.println(end - second);
    }
}
