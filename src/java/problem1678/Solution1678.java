package problem1678;

/**
 * @author mango
 * @version 1.0
 * @description 1678. 设计 Goal 解析器
 * @email
 * @date 2022/4/2 11:06
 */
public class Solution1678 {

    public String interpret(String command) {
        command = command.replace("()", "o");
        command = command.replace("(al)", "al");
        return command;
    }

}
