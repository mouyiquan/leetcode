package middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mango
 * @version 1.0
 * @description 535. TinyURL 的加密与解密
 * https://leetcode.cn/problems/encode-and-decode-tinyurl/
 * @email
 * @date 2022/6/29 8:27
 */
public class Solution535 {

    /**
     * 使用自增id去匹配地址
     * 并使用LRU机制实现多地址统一短地址，用空间换空间
     */
    private Map<Integer, String> dataBase = new HashMap<Integer, String>();
    private int id;

    public String encode(String longUrl) {
        id++;
        dataBase.put(id, longUrl);
        return "http://tinyurl.com/" + id;
    }

    public String decode(String shortUrl) {
        int p = shortUrl.lastIndexOf('/') + 1;
        int key = Integer.parseInt(shortUrl.substring(p));
        return dataBase.get(key);
    }

}
