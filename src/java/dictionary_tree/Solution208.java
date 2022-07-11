package dictionary_tree;

import offer.Solution38;

/**
 * @author mango
 * @version 1.0
 * @description 208. 实现 Trie (前缀树)
 * https://leetcode.cn/problems/implement-trie-prefix-tree/
 * @email
 * @date 2022/7/11 9:08
 */
public class Solution208 {

    boolean isFinished;

    Solution208[] trie;

    public Solution208() {
        isFinished = false;
        trie = new Solution208[26];
    }

    public void insert(String word) {
        Solution208 cur = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (cur.trie[index] == null){
                cur.trie[index] = new Solution208();
            }
            cur = cur.trie[index];
        }
        cur.isFinished = true;
    }

    public boolean search(String word) {
        Solution208 cur = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (cur.trie[index] == null){
               return false;
            }
            cur = cur.trie[index];
        }
        return cur.isFinished;
    }

    public boolean startsWith(String prefix) {
        Solution208 cur = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (cur.trie[index] == null){
                return false;
            }
            cur = cur.trie[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Solution208 solution208 = new Solution208();
        solution208.insert("apple");
        System.out.println(solution208.search("apple"));
        System.out.println(solution208.search("app"));
        System.out.println(solution208.startsWith("app"));
        solution208.insert("app");
        System.out.println(solution208.search("app"));
    }
}
