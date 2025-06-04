package com.example;

public class Stage1 {
    public static void main(String[] args) {
        String string = removeConsecutiveChars("aaabccdd");
        System.out.println(string);
    }

    /**
     * 移除连续3次及以上相同的字符（双指针法）
     * @param input 输入字符串（仅包含a-z）
     * @return 处理后的字符串
     */
    public static String removeConsecutiveChars(String input) {
        if (input == null || input.length() < 3) {
            return input;
        }

        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0, n = chars.length;

        while (i < n) {
            char current = chars[i];
            int j = i + 1;
            // 找到连续字符的结束位置
            while (j < n && chars[j] == current) {
                j++;
            }
            // 如果连续字符数 <3，保留
            if (j - i < 3) {
                sb.append(input.substring(i, j));
            }
            i = j; // 跳过已处理的部分
        }

        String result = sb.toString();
        // 递归处理，直到字符串不再变化
        return result.length() == input.length() ? result : removeConsecutiveChars(result);
    }
}