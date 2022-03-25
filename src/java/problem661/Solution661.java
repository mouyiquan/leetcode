package problem661;

/**
 * @author mango
 * @version 1.0
 * @description 图片平滑器
 * @email
 * @date 2022/3/24 8:42
 */
public class Solution661 {


    /**
     * 该题可以使用前缀和优化
     * @param img
     * @return
     */
    public static int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int num = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    if (x < 0 || x >= m){
                        continue;
                    }
                    for (int y = j - 1; y <= j + 1 ; y++) {
                        if (y < 0 || y >= n){
                            continue;
                        }
                        num++;
                        sum += img[x][y];
                    }
                }
                result[i][j] = sum / num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] nums = new int[5][6];
        //通过循环随机向二维数组中添加数据
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = (int)(Math.random()*9+1);
            }
        }
        System.out.println(nums);
        imageSmoother(nums);
    }

}
