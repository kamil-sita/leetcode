package pl.ksitarski.rangesumquery2dimmutable;

class NumMatrix {
    private final int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        sumMatrix = new int[matrix.length][matrix[0].length];

        for (int y = 0; y < matrix[0].length; y++) {
            for (int x = 0; x < matrix.length; x++) {
                final int x1 = x - 1;
                final int y1 = y - 1;
                final int upperSum = mySum(x, y1);
                final int leftSum = mySum(x1, y);
                final int upperLeftSum = mySum(x1, y1);
                final int myVal = matrix[x][y];
                sumMatrix[x][y] = myVal + upperSum + leftSum - upperLeftSum;
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1 = row1 - 1;
        col1 = col1 - 1;
        return mySum(row2, col2) - mySum(row1, col2) - mySum(row2, col1) + mySum(row1, col1);
    }

    private int mySum(int x, int y) {
        if (x < 0) {
            return 0;
        }
        if (y < 0) {
            return 0;
        }
        return sumMatrix[x][y];
    }
}
