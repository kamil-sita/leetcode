package pl.ksitarski.nqueens;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> out = new ArrayList<>();
        solveNq(out, new ArrayList<>(n), n);
        return out;
    }

    private static void solveNq(List<List<String>> out, List<Integer> current, int n) {
        boolean[] used = new boolean[n];
        //current legal?
        //    we have to check only diagonals, since with this approach multiple queens in same row aren't possible
        //    and cols are optimized in optimized recursive call

        for (int i = 0; i < current.size(); i++) {
            used[current.get(i)] = true;
            int atI = current.get(i);
            int k = 0;
            for (int j = i + 1; j < current.size(); j++) {
                k++;
                int atJ = current.get(j);
                if (atJ == atI - k || atJ == atI + k) {
                    return;
                }
            }
        }

        //is size equal to n? if yes, then it's a solution

        if (current.size() == n) {
            List<String> solution = new ArrayList<>();
            for (int i : current) {
                char[] s = new char[n];
                int k = 0;
                for (; k < i; k++) {
                    s[k] = '.';
                }
                s[k] = 'Q';
                k++;
                for (; k < n; k++) {
                    s[k] = '.';
                }
                solution.add(new String(s));
            }

            out.add(solution);
            return;
        }


        //else - optimized recursive call
        for (int i = 0; i < n; i++) {

            if (!used[i]) {
                List<Integer> integers = new ArrayList<>(n);
                integers.addAll(current);
                integers.add(i);
                solveNq(out, integers, n);
            }
        }

    }
}