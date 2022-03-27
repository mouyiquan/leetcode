package problem2028;

/**
 * @author mou
 */
public class Solution2028 {

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int missingSum = 0;
        missingSum = (rolls.length + n) * mean;

        for (int i = 0; i < rolls.length; i++) {
            missingSum -= rolls[i];
        }

        if (n*6 >= missingSum && missingSum >= n){
            int quotient = missingSum / n, remainder = missingSum % n;
            int[] missing = new int[n];
            for (int i = 0; i < n; i++) {
                missing[i] = quotient + (i < remainder ? 1 : 0);
            }
            return missing;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] rolls = new int[]{1,5,6};
        int mean = 3;
        int n = 4;
        System.out.println(missingRolls(rolls, mean, n));
    }
}
