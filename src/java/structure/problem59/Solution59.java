package structure.problem59;

/**
 * @author mango
 * @version 1.0
 * @description 59. 螺旋矩阵 II
 * @email
 * @date 2022/6/9 9:01
 */
public class Solution59 {

    public static int[][] generateMatrix(int n) {

        int[][] data = new int[n][n];
        int row = 0;
        int col = 0;
        int number = 1;

        int flag = 1;

        int i = n * n;

        while(number <= i){
            if (flag == 1){
                data[row][col] = number;
                number++;
                col++;
                if (col + row == n){
                    flag++;
                    col--;
                    row++;
                }
                continue;
            }
            if (flag == 2){
                data[row][col] = number;
                number++;
                row++;
                if (col - row == -1){
                    flag++;
                    row--;
                    col--;
                }
                continue;
            }
            if (flag == 3){
                data[row][col] = number;
                number++;
                col--;
                if (col + row + 2 == n){
                    flag++;
                    col++;
                    row--;
                }
                continue;
            }
            if (flag == 4){
                data[row][col] = number;
                number++;
                row--;
                if (col - row == 0){
                    flag=1;
                    row++;
                    col++;
                }
            }
        }

        return data;
    }

    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
        System.out.println(1);
    }
}
