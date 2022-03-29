package problem30;


import java.util.*;

/**
 * @author mango
 * @version 1.0
 * @description 30. 串联所有单词的子串
 *
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 *
 * @email
 * @date 2022/3/29 10:31
 */
public class Solution30 {


    /**
     * 解法1.滑动窗口+组合
     * 这种方法会导致超时，但是可以应对各种复制情况
     */
    private static List<Integer> findSubstring(String s, String[] words) {

        List<String> strings = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            strings.add(words[i]);
        }

        List<String> combine = combine("", strings);

        int right = combine.get(0).length();

        //1.用map存words所有的可能
        Set<String> hashSet = new HashSet<>();
        for (int i = 0; i < combine.size(); i++) {
            hashSet.add(combine.get(i));
        }

        //滑动窗口
        int length = s.length();
        List<Integer> res = new LinkedList<>();

        if (length < right){
            return res;
        }

        for (int i = 0; i + right <= s.length(); i++) {
            String substring = s.substring(i, i + right);
            if (hashSet.contains(substring)){
                res.add(i);
            }
        }

        return res;
    }

    //递归组合
    private static List<String> combine(String s, List<String> words){
        ArrayList<String> res = new ArrayList<>();
        if (words.size() == 1){
            res.add(s + words.get(0));
        }
        for (int i = 0; i < words.size(); i++) {
            List<String> tmp = new LinkedList<>(words);
            tmp.remove(i);
            res.addAll(combine(s + words.get(i), tmp));
        }

        return res;
    }

    /**
     * 解法2.滑动窗口+ MAP
     * 这种方法会导致超时，但是可以应对各种复制情况
     */
    private static List<Integer> findSubstring2(String s, String[] words) {

        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], Optional.ofNullable(map.get(words[i])).orElse(0) + 1);
        }

        int strLen = words[0].length();
        int right = strLen * words.length;


        //滑动窗口
        int length = s.length();
        List<Integer> res = new ArrayList<>();

        if (length < right){
            return res;
        }

        for (int i = 0; i + right <= s.length(); i++) {
            String substring = s.substring(i, i + right);
            HashMap<String, Integer> tmp = new HashMap<>(map);

            boolean flag = true;
            for (int j = 0; j + strLen <= substring.length();j+=strLen){
                String subSub = substring.substring(j, j + strLen);
                boolean b = tmp.containsKey(subSub);
                if (!b){
                    flag = false;
                    break;
                }
                Integer integer = tmp.get(subSub);
                if (integer == 1){
                    tmp.remove(subSub);
                }else {
                    tmp.put(subSub, integer - 1);
                }
            }
            if (flag){
                res.add(i);
            }
        }

        return res;
    }


    public static void main(String[] args) {
//        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
//        String[] words = new String[]{"fooo","barr","wing","ding","wing"};
//
//        List<Integer> substring = findSubstring2(s, words);
//
//        for (int i = 0; i < substring.size(); i++) {
//            System.out.println(substring.get(i));
//        }

//        String s2 = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
//        String[] words2 = new String[]{"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
//
//        List<Integer> substring2 = findSubstring2(s2, words2);
//
//        for (int i = 0; i < substring2.size(); i++) {
//            System.out.println(substring2.get(i));
//        }


        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = new String[]{"word","good","best","good"};

        List<Integer> substring2 = findSubstring2(s2, words2);

        for (int i = 0; i < substring2.size(); i++) {
            System.out.println(substring2.get(i));
        }
    }
}
