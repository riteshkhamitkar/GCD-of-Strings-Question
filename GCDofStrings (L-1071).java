class Solution {
    /**
    * Find the GCD of strings. precondition: str1 <= str2
    */
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() > str2.length()) return gcdOfStrings(str2, str1);

        for (int n = str1.length(), i = n - 1; i >= 0; i--) {
            // check if we can divide equally
            int size = i + 1;
            if (n % size != 0 || str2.length() % size != 0)
                continue; // we can't divide with the current length. Hence no repetition possible

            String prefix = str1.substring(0, i + 1);
            boolean doesRepeat = true;
            for (int j = 0; doesRepeat && j < Math.max(str1.length(), str2.length()); j += size) {
                if (
                        (j < str1.length() && !str1.substring(j, j + size).equals(prefix)) ||
                        (j < str2.length() && !str2.substring(j, j + size).equals(prefix))
                ) {
                    doesRepeat = false;
                }
            }
            if (doesRepeat) return prefix;

        }

        return "";

    }
}
