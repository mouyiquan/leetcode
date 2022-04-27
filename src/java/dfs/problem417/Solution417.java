package dfs.problem417;


import java.util.ArrayList;
import java.util.List;

/**
 * @author mango
 * @version 1.0
 * @description TODO
 * @email
 * @date 2022/4/27 13:49
 */
public class Solution417 {

    //当前点向上下左右移动
    int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};


    int[][] newHeights ;

    int height;
    int width;
    /**
     * 题解： dfs求解
     * 从四个边的点出发，左上边和右上边分别出发，找到能到达的最远的点
     * 求交集
     * @param heights
     * @return
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //1.先获取二维素组的宽高
        this.height = heights.length;
        this.width = heights[0].length;
        this.newHeights = heights;

        int[][] atlantic = new int[height][width];
        int[][] pacific = new int[height][width];

        //2.进入循环的起点肯定是四条边的点
        //2.1 循环
        for (int i = 0; i < height; i++) {
            dfs(i, 0, pacific);
        }
        for (int i = 1; i < width; i++) {
            dfs(0, i, pacific);
        }
        //2.2 循环
        for (int i = 0; i < height; i++) {
            dfs(i, width-1, atlantic);
        }
        for (int i = 0; i < width; i++) {
            dfs(height-1, i, atlantic);
        }

        //返回数据
        List<List<Integer>> result = new ArrayList<>();
        //求交集
        for (int i = 0; i < atlantic.length; i++) {
            for (int j = 0; j < atlantic[0].length; j++) {
                if (atlantic[i][j] == 1 && atlantic[i][j] == pacific[i][j]){
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(i);
                    integers.add(j);
                    result.add(integers);
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col, int[][] collect){
        //已经判断过则不再判断
        if (collect[row][col] == 1){
            return;
        }
        collect[row][col] = 1;
        //结束循环的判断
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < height && newCol >= 0 && newCol < width && newHeights[newRow][newCol] >= newHeights[row][col]) {
                dfs(newRow, newCol, collect);
            }
        }
    }

    public static void main(String[] args) {
        Solution417 solution417 = new Solution417();
        System.out.println(solution417.pacificAtlantic(new int[][]{{1, 1}, {1, 1}, {1, 1}}));
    }

}
