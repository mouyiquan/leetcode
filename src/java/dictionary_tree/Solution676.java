package dictionary_tree;

/**
 * @author mango
 * @version 1.0
 * @description TODO
 * @email
 * @date 2022/7/11 8:34
 */
public class Solution676 {
    Trie root;

    public Solution676() {
        root = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Trie cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                int idx = ch - 'a';
                if (cur.child[idx] == null) {
                    cur.child[idx] = new Trie();
                }
                cur = cur.child[idx];
            }
            //最后一个节点标记finish
            cur.isFinished = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(searchWord, root, 0, false);
    }

    private boolean dfs(String searchWord, Trie node, int pos, boolean modified) {
        if (pos == searchWord.length()) {
            return modified && node.isFinished;
        }
        int idx = searchWord.charAt(pos) - 'a';
        if (node.child[idx] != null) {
            if (dfs(searchWord, node.child[idx], pos + 1, modified)) {
                return true;
            }
        }
        if (!modified) {
            for (int i = 0; i < 26; ++i) {
                if (i != idx && node.child[i] != null) {
                    if (dfs(searchWord, node.child[i], pos + 1, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Trie {
    boolean isFinished;
    Trie[] child;

    public Trie() {
        isFinished = false;
        child = new Trie[26];
    }
}
