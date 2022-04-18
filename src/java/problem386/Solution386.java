package problem386;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mango
 * @version 1.0
 * @description 386. 字典序排数
 * @email
 * @date 2022/4/18 8:29
 */
public class Solution386 {


    //巧妙解法
    public List<Integer> lexicalOrder(int n) {

        ArrayList<Integer> res = new ArrayList<>();
        int number = 1;

        for (int j = 0; j < n; j++) {
            res.add(number);
            if (number * 10 <= n){
                number *= 10;
            }else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return res;
    }

    //递归
    public List<Integer> lexicalOrder2(int n) {

        List<Integer> res = new ArrayList<>();

        for (int j = 1; j < 10; j++) {
           dfs(n,j,res);
        }
        return res;
    }

    private void dfs(int n, int j, List<Integer> res) {

        if(j > n){
            return ;
        }
        res.add(j);

        for (int i = 0; i < 10; i++) {
            dfs(n , j * 10 + i ,res);
        }
    }


    public static void main(String[] args) {
        Solution386 solution386 = new Solution386();
        List<Integer> list = solution386.lexicalOrder2(100);
        list.forEach(x->{
            System.out.println(x);
        });
    }
}
