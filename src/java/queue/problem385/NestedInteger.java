package queue.problem385;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mango
 * @version 1.0
 * @description TODO
 * @email
 * @date 2022/4/15 8:46
 */
public class NestedInteger {

    private int val;

    private List<NestedInteger> list;

    public NestedInteger(){
        this.val = 0;
        list = new ArrayList<>();
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value){
        this.val = value;
        list = new ArrayList<>();
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return this.val;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
        this.val = value;
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        this.list.add(ni);
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return this.list;
    }
}
