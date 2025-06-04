package com.example;

public class Stage2 {
    public static void main(String[] args) {
        String string = replaceConsecutiveChars("abcccbad");
        System.out.println(string);
    }
        public static String replaceConsecutiveChars(String input) {
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
                int count = j - i;
                // 如果连续字符数 >=3，替换为前一个字母；否则保留原字符
                if (count >= 3) {
                    char replacement = (current == 'a') ? 'a' : (char) (current - 1);
                    sb.append(replacement);
                } else {
                    sb.append(input.substring(i, j));
                }
                i = j; // 跳过已处理的部分
            }

            String result = sb.toString();
            // 递归处理，直到字符串不再变化
            return result.length() == input.length() ? result : replaceConsecutiveChars(result);
        }
}
