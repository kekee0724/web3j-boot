public class TestStr {

    //函数接口类
    public interface IFunction {
        String rotateAndRemoveSpaces(String str);
    }

    public static void main(String[] args) {
        // 给定一个字符串，去除空格，并旋转字符串，例如“ab cd”转为“dcba”
        String str = " ab c d ";
        timeUtil(str, TestStr::strUtils);

        timeUtil(str, TestStr::rotateAndRemoveSpaces);

        timeUtil(str, TestStr::rotateAndRemoveSpaces1);

    }

    private static void timeUtil(String str, IFunction myFunction) {
        long start1 = System.nanoTime();
        String result = myFunction.rotateAndRemoveSpaces(str);
        long end1 = System.nanoTime();
        System.out.println("执行耗时"+ (end1 - start1));
        System.out.println(result);
    }

    private static String strUtils(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.split("").length - 1; i >= 0; i--) {
            String x = str.split("")[i];
            if (!" ".equals(x)) {
                stringBuilder.append(x);
            }
        }
        return stringBuilder.toString();
    }


    public static String rotateAndRemoveSpaces(String input) {
        // 去除字符串中的空格
        input = input.replaceAll(" ", "");

        // 将字符串转换为字符数组以便反转
        char[] charArray = input.toCharArray();

        // 反转字符数组
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        // 构建最终结果字符串
        return new String(charArray);
    }


    public static String rotateAndRemoveSpaces1(String input) {
        // 创建一个StringBuilder来构建结果字符串
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (c != ' ') {
                resultBuilder.append(c);
            }
        }
        // StringBuilder中的字符
        return resultBuilder.toString();
    }

}
