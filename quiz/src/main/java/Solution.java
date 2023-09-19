//对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
//
// 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
//
//
//
// 示例 1：
//
//
//输入：str1 = "ABCABC", str2 = "ABC"
//输出："ABC"
//
//
// 示例 2：
//
//
//输入：str1 = "ABABAB", str2 = "ABAB"
//输出："AB"
//
//
// 示例 3：
//
//
//输入：str1 = "LEET", str2 = "CODE"
//输出：""
//
//
//
//
// 提示：
//
//
// 1 <= str1.length, str2.length <= 1000
// str1 和 str2 由大写英文字母组成
//
//
// Related Topics 数学 字符串 👍 353 👎 0


import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//leetcode submit region begin(e)
class Solution {
    public static void main(String[] args) {
//        demoInt();
//        System.out.println(canPlaceFlowers(new int[]{0, 1, 0}, 1));
        System.out.println(reverseVowels("leetcodeAa"));
    }

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (isYuan(s.charAt(i))) {
                list.add(i);
            }
        }

        int lastIdx = list.size() - 1;
        for (int i = lastIdx; i >= 0; i--) {
            int idx = list.get(i);
            char c = s.charAt(idx);
            chars[list.get(lastIdx - i)] = c;
        }
        return new String(chars);
    }

    private static boolean isYuan(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }


    private static void demoInt() {
        int int1 = 12;
        int int2 = 12;

        Integer integer1 = new Integer(12);
        Integer integer2 = new Integer(12);
        Integer integer3 = new Integer(127);

        Integer a1 = 127; //或者写成Integer a1 = Integer.valueOf(127);
        Integer a2 = 127;//或者写成Integer a2 = Integer.valueOf(127);

        Integer a = 128;
        Integer b = 128;

        System.out.println("int1 == int2 -> " + (int1 == int2));
        System.out.println("int1 == integer1 -> " + (int1 == integer1));
        System.out.println("integer1 == integer2 -> " + (integer1 == integer2));
        System.out.println("integer3 == a1 -> " + (integer3 == a1));
        System.out.println("a1 == a2 -> " + (a1 == a2));
        System.out.println("a == b -> " + (a == b));
    }

    /**
     * 贪心
     * 能种花的地方
     * 当前位置没有花
     * 前面要么没有花, 要么是边界
     * 后面要么没有花, 要么是边界
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        ExecutorService single = Executors.newSingleThreadExecutor();
        int length = flowerbed.length;

        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == length - 1 || flowerbed[i + 1] == 0)) {
                n--;
                //把花种上
                flowerbed[i] = 1;
            }
            if (n <= 0) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
