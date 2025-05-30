public class RabinKarp {
    static final int PRIME = 101; // Prime for hashing

    static void search(String txt, String pat) {
        int m = pat.length(), n = txt.length();
        int patHash = 0, txtHash = 0, h = 1;

        for (int i = 0; i < m - 1; i++) h = (h * 256) % PRIME; // Hash multiplier

        for (int i = 0; i < m; i++) {
            patHash = (256 * patHash + pat.charAt(i)) % PRIME;
            txtHash = (256 * txtHash + txt.charAt(i)) % PRIME;
        }

        for (int i = 0; i <= n - m; i++) {
            if (patHash == txtHash && txt.substring(i, i + m).equals(pat)) {
                System.out.println("Pattern found at index: " + i);
            }

            if (i < n - m) {
                txtHash = (256 * (txtHash - txt.charAt(i) * h) + txt.charAt(i + m)) % PRIME;
                if (txtHash < 0) txtHash += PRIME;
            }
        }
    }

    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        search(txt, pat);
    }
}