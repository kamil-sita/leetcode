package pl.ksitarski.dividetwointegers;

class Solution {
    public int divide(int dividend, int divisor) {
        //negatives have 1 value more which is useful for edge cases - calculations are done on negative numbers

        boolean isNegative = dividend < 0 ^ divisor < 0;


        int negativeDividend = dividend < 0 ? dividend : -dividend;
        int negativeDivisor = divisor < 0 ? divisor : -divisor;

        if (negativeDivisor < negativeDividend) {
            return 0;
        }

        int m = 0;

        if (negativeDivisor == -1) {
            m = negativeDividend;
        } else {

            int maxOptimizationLevel = 0;

            for (int j = 0; j < 8; j++) {
                for (int i = 1; i < 30; i++) {
                    if (bitAt(negativeDivisor, i)) {
                        maxOptimizationLevel = i;
                    } else {
                        break;
                    }
                }

                while (negativeDividend <= (negativeDivisor << maxOptimizationLevel)) {
                    negativeDividend -= (negativeDivisor << maxOptimizationLevel);
                    m-=(1<<maxOptimizationLevel);
                }

                if (maxOptimizationLevel < 2) {
                    break;
                }
            }

            while (negativeDividend <= negativeDivisor) {
                negativeDividend -= negativeDivisor;
                m-=1;
            }
        }


        if (m == Integer.MIN_VALUE) {
            if (!isNegative) {
                return Integer.MAX_VALUE;
            }
        }

        return isNegative ? m : -m;
    }

    public boolean bitAt(int val, int pos) {
        return (val & (1 << (31 - pos))) != 0;
    }
}