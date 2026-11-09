package univ_assignments.DAA_ASS_4;

import java.util.*;

public class Marker {

    // Mission 3a: prefix function
    public static int[] prefixFunction(String p) {
        int m = p.length();
        int[] pi = new int[m];
        int k = 0;                                           // length of the current border of p[0..i-1]
        for (int i = 1; i < m; i++) {
            while (k > 0 && p.charAt(i) != p.charAt(k)) k = pi[k - 1];   // the border cannot be extended: try a shorter one
            if (p.charAt(i) == p.charAt(k)) k++;             // the border grows by one letter
            pi[i] = k;
        }
        return pi;
    }

    // Mission 3b: KMP, all start positions
    public static int[] findAll(String text, String p) {
        int n = text.length(), m = p.length();
        if (m == 0 || m > n) return new int[0];
        int[] pi = prefixFunction(p);
        int[] found = new int[n - m + 1];                    // there cannot be more occurrences than start positions
        int count = 0;
        int k = 0;                                           // how many letters of p match the text ending at the pointer i
        for (int i = 0; i < n; i++) {                        // the pointer i in the text only goes forward
            while (k > 0 && text.charAt(i) != p.charAt(k)) k = pi[k - 1];   // mismatch: move the PATTERN, not the text
            if (text.charAt(i) == p.charAt(k)) k++;
            if (k == m) {                                    // the whole pattern matched: it started at i - m + 1
                found[count++] = i - m + 1;
                k = pi[m - 1];                               // go on with the longest border: the next match may overlap this one
            }
        }
        return Arrays.copyOf(found, count);
    }

    // Mission 4: Rabin-Karp
    public static int sharedWords(String a, String b, int k) {
        return sharedWords(a, b, k, MOD);
    }

    // hash = sum of letter * BASE^(position from the right) modulo MOD
    private static final long BASE = 911382323L, MOD = 972663749L;

    // the same, with the size of the hash (the modulus) as a parameter
    static int sharedWords(String a, String b, int k, long mod) {
        int n = a.length(), m = b.length();
        if (k <= 0 || k > n || k > m) return 0;
        long pow = 1;                                        // BASE^(k-1) modulo mod: the weight of the oldest letter of a window
        for (int i = 1; i < k; i++) pow = pow * BASE % mod;

        // step 1: the hash of every window of b -> the start positions of the windows with this hash
        HashMap<Long, ArrayList<Integer>> windowsOfB = new HashMap<>();
        long h = 0;
        for (int i = 0; i < m; i++) {
            if (i >= k) h = (h - b.charAt(i - k) * pow % mod + mod) % mod;   // the oldest letter leaves the window
            h = (h * BASE + b.charAt(i)) % mod;                              // the new letter comes in
            if (i >= k - 1) windowsOfB.computeIfAbsent(h, x -> new ArrayList<>()).add(i - k + 1);
        }

        // step 2: the same rolling hash over a; when the hash is found in b, COMPARE THE LETTERS
        int count = 0;
        h = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) h = (h - a.charAt(i - k) * pow % mod + mod) % mod;
            h = (h * BASE + a.charAt(i)) % mod;
            if (i < k - 1) continue;                         // the first window is not complete yet
            ArrayList<Integer> candidates = windowsOfB.get(h);
            if (candidates == null) continue;
            for (int pos : candidates) {
                if (sameLetters(a, i - k + 1, b, pos, k)) { count++; break; }   // count this position of a once
            }
        }
        return count;
    }

    // true if the k letters of s from position i are the same as the k letters of t from position j
    private static boolean sameLetters(String s, int i, String t, int j, int k) {
        for (int x = 0; x < k; x++) if (s.charAt(i + x) != t.charAt(j + x)) return false;
        return true;
    }
}