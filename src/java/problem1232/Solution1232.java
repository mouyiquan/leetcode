package problem1232;

/**
 * @author mango
 * @version 1.0
 * @description 1232. 缀点成线
 * 给定一个数组coordinates，其中coordinates[i] = [x, y]，[x, y]表示横坐标为 x、纵坐标为 y的点。
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上。
 * 将数组转化为过原点的线
 * @email
 * @date 2022/3/28 11:08
 */
public class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
        int n = coordinates.length;
        for (int i = 0; i < n; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }
        int A = coordinates[1][1], B = -coordinates[1][0];
        for (int i = 2; i < n; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if (A * x + B * y != 0) {
                return false;
            }
        }
        return true;
    }
}
