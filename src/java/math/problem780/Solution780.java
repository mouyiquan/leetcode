package math.problem780;

/**
 * 780. 到达终点
 */
public class Solution780 {
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == ty) {
                break;
            }
            if (tx > ty) {
                if (ty > sy) {
                    tx %= ty;
                }
                if (ty == sy) {
                    return (tx - sx) % ty == 0;
                }
            } else {
                if (tx > sx) {
                    ty %= tx;
                }
                if (tx == sx) {
                    return (ty - sy) % tx == 0;
                }
            }
        }

        return (tx == sx && ty == sy);
    }


}
