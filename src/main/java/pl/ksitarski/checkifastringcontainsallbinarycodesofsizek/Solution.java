package pl.ksitarski.checkifastringcontainsallbinarycodesofsizek;

class Solution {
    public boolean hasAllCodes(String s, int k) {

        int neededCodes = 1 << k;

        if (neededCodes > s.length()) {
            return false;
        }

        int[] numbers = new int[s.length()];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = s.charAt(i) == '0' ? 0 : 1;;
        }

        boolean[] exists = new boolean[neededCodes];

        int codesInserted = 0;

        for (int i = k - 1; i < s.length(); i++) {

            int no = 0;
            for (int j = i + 1 - k; j <= i; j++) {
                no = no << 1;
                no += numbers[j];
            }

            if (!exists[no]) {
                codesInserted++;
                exists[no] = true;
            }

            int possibleCodesLeft = s.length() - i;

            if (codesInserted == neededCodes) {
                return true;
            }

            if (neededCodes - codesInserted > possibleCodesLeft) {
                return false;
            }
        }
        return codesInserted == neededCodes;
    }
}
