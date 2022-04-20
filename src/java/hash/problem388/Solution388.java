package hash.problem388;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mango
 * @version 1.0
 * @description TODO
 * @email
 * @date 2022/4/20 13:04
 */
public class Solution388 {
    public int lengthLongestPath(String input) {
        int length = input.length();
        
        int maxLength = 0;
        
        //当前状态
        //当前的字符串
        StringBuilder curStr;
        //当前是否为目录（遇到符号.则不是目录，为文件）
        boolean dirFlag;

        //保存当前指针的每个层级的目录
        Map<Integer, String> map = new HashMap<>();
        map.put(-1,"");
        map.put(0,"");

        //上次的层级
        int lastLevel = 0;
        
        for (int i = 0; i < length; i++) {
            //当前是文件夹
            dirFlag = true;
            //当前层级数
            int level = 0;
            //清空当前字符串
            curStr = new StringBuilder();
            //获取当前的层级
            while (i < length && input.charAt(i) == '\t') {
                level++;
                i++;
            }
            //获取当前目录的字符串
            while (i < length && input.charAt(i) != '\n'&& input.charAt(i) != '\t') {
                curStr.append(input.charAt(i));
                if (input.charAt(i) == '.'){
                    dirFlag = false;
                }
                i++;
            }
            if (curStr.length() > 0){
          
                //判定为文件还是文件夹
                if (!dirFlag){
                    int j = 1;
                    //计算长度 (父级目录 + /符号的长度 + 当前文件的长度)
                    //如果level = 0，且得到的字符串为空的表，表示没有父级目录，就不需要 + 1
                    int parentLength = map.get(level - 1).length();
                    if (parentLength == 0){
                        j=0;
                    }else {
                        //需要减去顶级目录的 / 占位符
                        parentLength--;
                    }
                    maxLength = Math.max(maxLength, parentLength + j + curStr.length());
                }else {
                    String s = map.get(level - 1);
                    //目录增加
//                    if (lastLevel < level){
                        s = s + "/" + curStr;
                        map.put(level, s);
//                    }
                    //目录相等表示需要用父级目录进行追加
//                    if (lastLevel == level){
//                        s = s + "/" + curStr;
//                        map.put(level, s);
//                    }
                    //
//                    if (lastLevel > level){
//                        map.put(level, s);
//                    }
                }
                lastLevel = level;
            }
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        Solution388 solution388 = new Solution388();
        System.out.println(solution388.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}
