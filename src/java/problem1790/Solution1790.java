package problem1790;

/**
 * @author mango
 * @version 1.0
 * @description 1790. 仅执行一次字符串交换能否使两个字符串相等
 * @email
 * @date 2022/3/28 9:55
 */
public class Solution1790 {

    public boolean areAlmostEqual(String s1, String s2) {
        int count=0;
        //长度不等，直接返回false
        if(s1.length()!=s2.length()) return false;
        char first='1',second='1';
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(i)) continue;
            //超过两个不等，返回false
            if(count==2) return false;
            //第一次不等，记录字符
            if(count==0){
                first=s1.charAt(i);
                second=s2.charAt(i);
            }
            //第二次不等，判断能否交换
            if(count==1){
                if(s1.charAt(i)!=second||s2.charAt(i)!=first) return false;
            }
            count++;
        }
        return count==0||count==2;
    }

}
