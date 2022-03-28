package problem1779;

/**
 * @author mango
 * @version 1.0
 * @description 1779. 找到最近的有相同 X 或 Y 坐标的点
 * 给你两个整数 x 和 y ，表示你在一个笛卡尔坐标系下的 (x, y) 处。同时，在同一个坐标系下给你一个数组 points ，其中 points[i] = [ai, bi] 表示在 (ai, bi) 处有一个点。当一个点与你所在的位置有相同的 x 坐标或者相同的 y 坐标时，我们称这个点是 有效的 。
 * 请返回距离你当前位置 曼哈顿距离 最近的 有效 点的下标（下标从 0 开始）。如果有多个最近的有效点，请返回下标 最小 的一个。如果没有有效点，请返回 -1 。
 * 两个点 (x1, y1) 和 (x2, y2) 之间的 曼哈顿距离 为 abs(x1 - x2) + abs(y1 - y2) 。
 * @email
 * @date 2022/3/28 9:40
 */
public class Solution1779 {

    public static int nearestValidPoint(int x, int y, int[][] points) {
        int mi = Integer.MAX_VALUE, mark = -1;
        for(int i = 0, a, b, now; i < points.length; i++) {
            a = points[i][0];
            b = points[i][1];

            if(a == x || b == y) {
                now = Math.abs(a - x) + Math.abs(b - y);
                if(now < mi) {
                    mi = now;
                    mark = i;
                }
            }
        }
        return mark;
    }

    public static void main(String[] args) {
        int x = 3, y = 4;
        int[][]  points = new int[][]{{1,2},{3,1},{2,4},{2,3},{4,4}};
        System.out.println(nearestValidPoint(x, y, points));
    }

}
