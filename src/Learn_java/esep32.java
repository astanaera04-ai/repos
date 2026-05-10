package Learn_java;

public class esep32 {

    public static boolean isV(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static int maxVowels(String s, int k) {
        int count = 0;

        for (int i = 0; i < k; i++) {
            if (isV(s.charAt(i))) {
                count++;
            }
        }

        int max = count;

        for (int i = k; i < s.length(); i++) {
            if (isV(s.charAt(i))) {
                count++;
            }
            if (isV(s.charAt(i - k))) {
                count--;
            }

            if (count > max) {
                max = count;
            }

            if (max == k) {
                return max;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("1-тест (abciiidef): " + maxVowels("abciiidef", 3)); // Жауабы: 3
        System.out.println("2-тест (leetcode): " + maxVowels("leetcode", 3));   // Жауабы: 2
    }
}
