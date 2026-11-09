package univ_assignments.DAA_ASS_4;

public class Strains {

    // Mission 1: edit distance
    public static int editDistance(String a, String b) {
        int n = a.length(), m = b.length();
        // d[i][j] = the smallest number of changes that turn the first i letters of a into the first j letters of b
        int[][] d = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) d[i][0] = i;   // first i letters of a -> empty word: delete i letters
        for (int j = 0; j <= m; j++) d[0][j] = j;   // empty word -> first j letters of b: insert j letters
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int replace = d[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1);  // last letters: keep (0) or replace (1)
                int delete = d[i - 1][j] + 1;   // delete the last letter of a
                int insert = d[i][j - 1] + 1;   // insert the last letter of b
                d[i][j] = Math.min(replace, Math.min(delete, insert));
            }
        }
        return d[n][m];
    }

    // Mission 2: longest common subsequence
    public static int lcsLength(String a, String b) {
        int n = a.length(), m = b.length();
        // d[i][j] = the length of the longest common subsequence of the first i letters of a and the first j letters of b
        int[][] d = new int[n + 1][m + 1];          // the first row and column stay 0: one of the words is empty
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) d[i][j] = d[i - 1][j - 1] + 1;       // equal letters: diagonal + 1
                else d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);                          // otherwise the better of top and left
            }
        }
        return d[n][m];
    }
}