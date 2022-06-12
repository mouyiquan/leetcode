package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 13. 机器人的运动范围
 */
public class Offer13 {



    public static int movingCount(int m, int n, int k) {

        Set<String> stringSet = new HashSet<>();

        stringSet.add("0-0");

        if (m > 1){
            movingCountNew(m,n,1,0,k,stringSet);
        }
        if (n > 1){
            movingCountNew(m,n,0,1,k,stringSet);
        }

        return stringSet.size();
    }

    public static void movingCountNew(int m, int n ,int x, int y, int k,Set<String> stringSet) {
        int sum = 0;
        int a = x;
        int b = y;
        while (a !=0 ){
            sum += a % 10;
            a = a / 10;
        }
        while (b !=0 ){
            sum += b % 10;
            b = b / 10;
        }

        if (sum <= k ){
            stringSet.add(x + "-" + y);

            if (m-1>x){
                movingCountNew(m,n,x+1,y,k,stringSet);
            }
            if (n-1>y){
                movingCountNew(m,n,x,y+1,k,stringSet);
            }
        }

    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(movingCount(36, 11, 15));
        long e = System.currentTimeMillis();
        System.out.println((e-l) / 1000);
    }
}
