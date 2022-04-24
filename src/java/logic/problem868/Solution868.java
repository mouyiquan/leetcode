package logic.problem868;

/**
 * @author mango
 * @version 1.0
 * @description TODO
 * @email
 * @date 2022/4/24 8:56
 */
public class Solution868 {

    public int binaryGap(int n){

        //上一次1出现的位置
        int lastIndex = -1;
        //当前的下标
        int cur = 0;
        //返回结果
        int result = 0;

        //如果n不等于0则一直进行
        while (n > 0){
            //(n&1) == 判断当前最小位，是否为1，
            // 如果是1需要保存当前1的位置，
            // 如果上次出现1的位置不是初始的值，则进行判断
            if ((n&1) == 1 && lastIndex!= -1){
                result = Math.max(cur-lastIndex, result);
                lastIndex = cur;
            }else if ((n&1) == 1 ){
                lastIndex = cur;
            }
            //向右移动一位
            n = n >> 1;
            cur++;
        }

        return result;
    }

    public static void main(String[] args) {

        Solution868 solution868 = new Solution868();
        System.out.println(solution868.binaryGap(22));
        System.out.println(solution868.binaryGap(8));
        System.out.println(solution868.binaryGap(6));
        System.out.println(solution868.binaryGap(5));

    }

}
